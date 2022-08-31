<template>
	<el-container>
	    <el-header style="font-size: 12px,width:100%">
			<el-input class="input" type="text" clearable placeholder="请输入用户名称" v-model="userName" />
			<el-select  v-model="userRole" clearable placeholder="选择用户角色">
			    <el-option
			      v-for="item in selectRole"
				  
			      :label="item.label"
			      :value="item.value">
			    </el-option>
			  </el-select>
			  
	      <el-button round class="btn" @click="queryClick">查询</el-button>
	      
	    </el-header>
	    
		<el-main>
		<el-table
		 :data="userList"
		  style="width: 100%">
		  <el-table-column :prop="item.prop" :label="item.label" v-for="item,index in userArrays" :key="item.index"></el-table-column>
		  <el-table-column label="操作" width="210">
			   <template slot-scope="scope">
				 <el-button
				   size="mini"
				   @click="handleQuery(scope.$index, scope.row)">查看</el-button>
				   <el-button
					 size="mini"
					 @click="handleAlter(scope.$index, scope.row)">修改</el-button>
				 <el-button
				   size="mini"
				   type="danger"
				   @click="handleDelete(scope.$index, scope.row)">删除</el-button>
			   </template>
			 </el-table-column>
		 </el-table-column>
		  
		</el-table>
		<el-pagination
		class="page"
		 background
		 hide-on-single-page
		  layout="prev, pager, next"
		  :total="userCount"
			:page-size="pageSize"
			  @current-change="currentChange"
			>
		</el-pagination>
		<h3 style="margin-left: 3%;">共{{userCount}}条记录</h3>
		</el-main>
	  </el-container>
</template>

<script>
	import {getUserCount,getUserPageList,getUserList,deleteUser} from "../../network/data/user.js"
	import {getRoleNameList} from "../../network/data/role.js"
	export default{
		name:"userTable",
		activated() {
			getUserCount().then(res =>{
				this.userCount = res
				
			})
	
			getRoleNameList().then(res =>{
					//清空数组
					this.selectRole.splice(0,this.selectRole.length)
				let arr = []
				
				for(let i in res){
					 arr = {
						value:res[i].id,
						label:res[i].roleName
					}		
					this.selectRole.push(arr)
				}
			}			
			)
			setTimeout(()=>{
				getUserPageList(this.userName,this.userRole,1,this.pageSize).then(res =>{
				
					for(let i in res){
						if(res[i].gender == 1)
						 res[i].userGender = "女"		
						if(res[i].gender == 2)
						 res[i].userGender = "男"
					}
					this.userList = res
					
				},100)
			})
			
		},
		data(){
			return{
				userArrays:[{"label":"用户编码",prop:"userCode"},
							{"label":"用户名称",prop:"userName"},
							{"label":"性别",prop:"userGender"},
							{"label":"年龄",prop:"age"},
							{"label":"电话",prop:"phone"},
							{"label":"用户角色",prop:"userRoleName"}
											
				],
				userList:[],
				userName:'',
				userRole:''	,	
				selectRole:[],
				userCount:10,
				pageSize:4
			}
		},
		methods:{
			queryClick(){
				getUserPageList(this.userName,this.userRole,1,this.pageSize).then(res =>{
				
					for(let i in res){
						if(res[i].gender == 1)
						 res[i].userGender = "女"		
						if(res[i].gender == 2)
						 res[i].userGender = "男"
					}
					this.userList = res
					
				})
				getUserCount(this.userName,this.userRole).then(res =>{
					this.userCount = res
				})
			},
			handleQuery(index,item){
				this.$router.push({
					path:'/userQuery',
					query:{
						item
					}
				})
			
			},
			handleAlter(index,item){
				this.$router.push({
					path:'/userAlter',
					query:{
						item
					}
				})
			},
			handleDelete(index,item){
				deleteUser(item.id).then( res => {
					this.userList.splice(index,1)
					this.userCount--
					this.$toast.show(res,1500)
				})
				
				
			},
			currentChange(currentPage){
				getUserPageList(this.userName,this.userRole,currentPage,this.pageSize).then(res =>{
				
					for(let i in res){
						if(res[i].gender == 1)
						 res[i].userGender = "女"		
						if(res[i].gender == 2)
						 res[i].userGender = "男"
					}
					this.userList = res
					
				})
			}
			
		}
	}
</script>

<style scoped="scoped">
	.input{
		width: 20%;
		margin-right: 11%;
		margin-left: 5%;
	}
	.btn{
		width: 10%;
		position:relative;
		left: 29.5%;
	}
	.page{
		
		margin-top: 1%;
		margin-left: 33%;
		margin-bottom: 3.5%;
	}
</style>

<template>
	<el-container>
	    <el-header style="font-size: 12px;width:100%;text-align: center;">
		
		<h3>供应商修改</h3>
	      
	    </el-header>
	    
		<el-main >
			<el-card class="box-card" >
				<div style="width: 30%; margin: 0 auto;">
		供应商编码：<el-input placeholder="请输入供应商编码" v-model="item.proCode" clearable/><br><br>
		供应商名称：<el-input placeholder="请输入供应商名称" v-model="item.proName" clearable/><br><br>
		供应商描述：<el-input placeholder="请输入供应商描述" v-model="item.proDesc" clearable/><br><br>
		联系人：<el-input placeholder="请输入联系人名称" v-model="item.proContact" clearable/><br><br>
		联系电话：<el-input placeholder="请输入联系电话" v-model="item.proPhone" clearable/><br><br>
		公司地址：<el-input placeholder="请输入供应商公司地址" v-model="item.proAddress" clearable/><br><br>
		传真：<el-input placeholder="请输入公司传真" v-model="item.proFax" clearable/><br><br>
		
				</div>
				<br><br>
				<div style="text-align: center; margin-right: 2%;">
				<el-button round class="backBtn" @click="saveClick">提交</el-button>
				<el-button round class="backBtn" @click="backClick">返回</el-button>
				</div>
		  </el-card >
		</el-main>
	  </el-container>
</template>

<script>
	import {modifyProvider} from "../../../network/data/provider.js"
	export default{
		name:"providerAlter",
		activated() {
				this.item = this.$route.query.item
		},
		data(){
			return{
				item:{}	
		}
		},
		methods:{
			saveClick(){
					this.item.modifyBy = this.$store.state.user.id
				modifyProvider(this.item).then(res => {
					this.$toast.show(res,1500)
				})
				setTimeout(() => {
					this.$router.push("/providerTable")
				},1500)
			},
			backClick(){
				this.$router.go(-1)
			}
			
		}
	}
</script>

<style scoped="scoped">
	h3{
		font-size: 24px;
		line-height: 12px;
		color: aliceblue;
	}
</style>

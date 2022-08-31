<template>
	<el-card  class="loginForm"  >
	<el-form>
	   <h3 >SMBMS管理系统</h3>
	  <h3 >账号登录</h3>
	 
	  <el-form-item prop="email" label-width="0">
	    <el-input 
	      class="inputItem"
	      v-model="userCode" 
	      placeholder="请输入您的管理员账号" 
	      prefix-icon="el-icon-user"/>
	  </el-form-item >
	  <el-form-item  label-width="0">
	    <el-input 
	      class="inputItem" 
	      v-model="password" 
	      placeholder="请输入您的密码" 
	      prefix-icon="el-icon-lock" 
	      type='password'/>
	  </el-form-item>
	  <el-button type="danger" size="medium" class="button" @click="loginClick">登录</el-button>
	 
	</el-form>
	</el-card>
</template>

<script>
	import {getLoginUser} from "../../network/data/user.js"
	
	export default{
		name:"Login",
		created() {
		},
		data(){
			return{
				userCode:"",
				password:"",
				user:""
				
			}
		},
		methods:{
			loginClick(){
				
			getLoginUser(this.userCode,this.password).then(res => {			
				this.user = res	
				
			})
			
			setTimeout(() => {
				if(this.user == ""){
				    this.$toast.show("登录失败,账号或密码错误！")
				}else{			
						if(this.user.gender == 1)
						 this.user.userGender = "女"		
						if(this.user.gender == 2)
						this.user.userGender = "男"
					
					// 把user保存在vuex和sessionstorage
					sessionStorage.setItem("user",this.user)
					this.$store.commit({
						type:'saveLoginUser',
						user:this.user
					})
					
					this.$router.push("/element")
				}
			},300)
			}
			}
	
		}
	
</script>

<style scoped="scoped">
	
	h3{
		margin-bottom: 8%;
	}
	.loginForm{
	  background-color: white;
	  margin: 0 auto;
	  padding: 30px;
	  position: absolute;
	  top: 25%;
	  left: 40%;
	  height: 360px;
	  width: 350px;
	 
	  text-align: center;
	}
	.button{
		margin-top: 5%;
		width: 40%;		
	}
	
	
</style>

<template>
	<el-container>
	    <el-header style="font-size: 12px;width:100%;text-align: center;">
		
		<h3>修改密码</h3>
	      
	    </el-header>
	    
		<el-main >
			<el-card class="box-card" >
				<el-form :model="item" :rules="rules" ref="updateForm">
				<div style="width: 30%; margin: 0 auto;">
		
				<el-form-item label="原密码:" prop="password" >
					<el-input placeholder="请输入原密码" v-model="item.password" clearable/>
				</el-form-item>
				
				<el-form-item label="新密码:" prop="newPassword" >
					<el-input placeholder="请输入新密码" v-model="item.newPassword" clearable/>
				</el-form-item>
				
				<el-form-item label="再次输入新密码:" prop="newPasswordAgain" >
					<el-input placeholder="请再次输入新密码" v-model="item.newPasswordAgain" clearable/>
				</el-form-item>
				
				</div>
				<div style="text-align: center; margin-right: 2%;">
				<el-button round class="backBtn" @click="saveClick">提交</el-button>
				<el-button round class="backBtn" @click="backClick">返回</el-button>
				</div>
				</el-form>
		  </el-card >
		</el-main>
	  </el-container>
</template>

<script>
	import {modifyUser} from "../../network/data/user.js"
	
	export default{
		name:"updatePassword",
		
		data(){
			
		 const checkPassword = (rule, value, callback) =>{
			 if(this.item.password !== this.user.userPassword){
				callback(new Error('请输入正确的用户密码！'))
			 }
			 callback()
		 }
		
		const checkNewPasswordAgain = (rule, value, callback) =>{
					 if(this.item.newPassword !== this.item.newPasswordAgain){
						callback(new Error('两次输入密码不一致！'))
					 }
					 callback()
		}		 
			return{
				user:JSON.parse(sessionStorage.getItem("user")),
				item:{
					password:"",
					newPassword:"",
					newPasswordAgain:""
				},
				newItem:{
					id:'',
					userPassword:""
				},
				rules:{
			//required 代表必填项   message 代表提示信息  trigger 代表 在什么时候触发校验
			  password: [{ required: true, message: '请输入用户密码', trigger: 'blur' },
			  {validator:checkPassword, trigger: 'blur'}],
			  
			  newPassword: [{ required: true, message: '请输入新密码', trigger: 'blur' }],
			  
			  newPasswordAgain: [
			    { required: true, message: '请再次输入密码', trigger: 'blur' },
			    { validator: checkNewPasswordAgain, trigger: 'blur' }
			  ]  
		}
				
		}
		},
		methods:{
			saveClick(){
				//如果验证没问题
		  // this.$refs.registerForm.validate(async valid => {
		  //   if (!valid) return
			 // addCustomer(this.customer)
			 
			 // this.$toast.show("注册成功！")
			 
		  //    this.$router.push('/login')
		  // })
				
				// modifyUser(this.item).then(res => {
				// 	this.$toast.show(res,1500)
				// })
				// setTimeout(() => {
				// 	this.$router.push("/userTable")
				// },1500)
				
				this.$refs.updateForm.validate(async valid =>{
					if (!valid) return
					this.newItem.id = this.user.id
					this.newItem.userPassword = this.item.newPassword
					
					modifyUser(this.newItem).then(res=> {
				 	this.$toast.show(res+"请重新登录",1500)	
					
					})
					setTimeout(() => {
						this.$router.push("/login")
					},1500)
				})
				
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

import {request} from '../request.js'

export function getLoginUser(userCode,userPassword) {
	return request({
		url: '/user/login',
		params:{
			userCode,
			userPassword
		}
	})
}
// 
// export function getUserList(userCode,userRole) {
// 	return request({
// 		url: '/user/queryList',
// 		params:{
// 			userCode,
// 			userRole
// 		}
// 	})
// }

export function getUserPageList(userCode,userRole,currentPage,pageSize) {
	return request({
		url: '/user/queryPageList',
		params:{
			userCode,
			userRole,
			currentPage,
			pageSize
		}
	})
}

export function getUserCount(userName,userRole) {
	return request({
		url: '/user/getUserCount',
		params:{
			userName,
			userRole
		}
	})
}

export function modifyUser(item) {
	return request({
		url: '/user/modify',
		params:item
		// {
		// 	id:item.id,
		// 	userName:item.userName,
		// 	gender:item.gender,
		// 	age:item.age,
		// 	phone:item.phone,
		// 	address:item.address,
		// 	userRole:item.userRole
			
		// }
	})
}

export function deleteUser(id){
	return request({
		url: '/user/delete',
		params:{
			id
		}
	})
}

export function addUser(item){
	return request({
		url: '/user/add',
		params:item

	// {
	// 		userName:item.userName,
	// 		userCode:item.userCode,
	// 		userPassword:item.userPassword,
	// 		gender:item.gender,
	// 		age:item.age,
	// 		birthday:item.birthday,
	// 		phone:item.phone,
	// 		userRole:item.userRole,
	// 		address:item.address,
	// 		createdBy:0	
	// 	}
	})
	
}
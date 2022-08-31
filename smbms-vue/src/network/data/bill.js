import {request} from '../request.js'

// export function getBillList(productName,providerId,isPayment) {
// 	return  request({
// 		url: '/bill/queryList',
// 		params:{
// 			productName,
// 			providerId,
// 			isPayment
// 		}
// 	})
// }

export function getBillPageList(productName,providerId,isPayment,currentPage,pageSize) {
	return request({
		url: '/bill/queryPageList',
		params:{
			productName,
			providerId,
			isPayment,
			currentPage,
			pageSize
		}
	})
}

export function getBillCount(productName,providerId,isPayment) {
	return request({
		url: '/bill/getBillCount',
		params:{
			productName,
			providerId,
			isPayment
		}
	})
}

export function modifyBill(item) {
	return request({
		url: '/bill/modify',
		params:item
	})
}

export function deleteBill(id){
	return request({
		url: '/bill/delete',
		params:{
			id
		}
	})
}

export function addBill(item){
	return request({
		url: '/bill/add',
		params:item
	})
}
import {request} from '../request.js'

export function getProviderList() {
	return request({
		url: '/provider/queryList'
	})
}

export function getProviderPageList(proCode,proName,currentPage,pageSize) {
	return request({
		url: '/provider/queryPageList',
		params:{
			proCode,
			proName,
			currentPage,
			pageSize
		}
	})
}


export function getProviderCount(proCode,proName) {
	return request({
		url: '/provider/getProviderCount',
		params:{
			proCode,
			proName
		}
	})
}



export function modifyProvider(item) {
	return request({
		url: '/provider/modify',
		params:item
	})
}

export function deleteProvider(id){
	return request({
		url: '/provider/delete',
		params:{
			id
		}
	})
}

export function addProvider(item){
	return request({
		url: '/provider/add',
		params:item
	})
}
import {request} from '../request.js'

export function getRoleNameList() {
	return request({
		url: '/role/queryList'
	})
}
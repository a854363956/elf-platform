package org.elf.mvc.models;

import java.util.List;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用来查找菜单节点
 * @author zhangj 
 * @email zhangjin0908@hotmail.com
 */
@Component
public class ElfBaseMenuModels {
	/**
	 * 返回给前端路由的实体对象
	 * @author zhangj
	 * @email zhangjin0908@hotmail.com
	 */
	public class MenuData{
		private String path;
		private String name;
		private String icon;
		private String component;
		private List<MenuData> routes;
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}
		public String getComponent() {
			return component;
		}
		public void setComponent(String component) {
			this.component = component;
		}
		public List<MenuData> getRoutes() {
			return routes;
		}
		public void setRoutes(List<MenuData> routes) {
			this.routes = routes;
		}
		
	}
	@Autowired
	private DSLContext dsl;
	
	/**
	 * 获取当前菜单带权限的信息
	 * @param roleId       角色ID
	 * @param equipmentId  设备ID
	 * @return  返回生成的类型
	 */
	public Object getMenuAuthority(long roleId,long equipmentId) {
		return null;
	}
	
	/**
	 * 获取当前没有权限的所有菜单信息
	 * @param roleId       角色ID
	 * @param equipmentId  设备类型
	 * @return  返回菜单信息
	 */
	public Object getMenuNoAuthority(long roleId,long equipmentId) {
		return null;
	}
}

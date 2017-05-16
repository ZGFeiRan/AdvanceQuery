package feiran.zg.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import feiran.zg.domain.Menu;
import feiran.zg.domain.Role;
import feiran.zg.service.BusinessService;
import feiran.zg.service.impl.BusinessServiceImpl;
import feiran.zg.utils.BeanUtilMap2Bean;


@WebServlet("/MyController")
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BusinessService bs = new BusinessServiceImpl();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if("listAllMenu".equals(operation)){
			listAllMenu(request,response);
		}else if("addMenu".equals(operation)){
			addMenu(request,response);
		}else if("listAllRole".equals(operation)){
			listAllRole(request,response);
		}else if("addRole".equals(operation)){
			addRole(request,response);
		}else if("grantMenu2RoleUI".equals(operation)){
			grantMenu2RoleUI(request,response);
		}else if("grantMenu2Role".equals(operation)){
			grantMenu2Role(request,response);
		}
	}

	private void grantMenu2Role(HttpServletRequest request, HttpServletResponse response) {

	}


	// 给角色分配菜单 //查询该角色已经分配的菜单
	//查询出所有的菜单（备用）
	private void grantMenu2RoleUI(HttpServletRequest request, HttpServletResponse response) {	
		String roleId = request.getParameter("roleId");
		Role role = bs.findRoleById(roleId);
		// 查询出所有的菜单，以备给该用户分配所用
		List<Menu> allMenu = bs.findAllMenu();
		request.setAttribute("role", role);
		request.setAttribute("allMenu", allMenu);
		
		try {
			request.getRequestDispatcher("/manager/grantRole.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}



	private void addRole(HttpServletRequest request, HttpServletResponse response) {
		Role role = BeanUtilMap2Bean.Map2Bean(request, Role.class);
		bs.addRole(role);
		try {
			request.getRequestDispatcher("/manager/addRole.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void listAllRole(HttpServletRequest request, HttpServletResponse response) {
		List<Role> allRole = bs.findAllRole();
		request.setAttribute("allRole", allRole);
//		System.out.println(allRole);
		try {
			request.getRequestDispatcher("/manager/listRoles.jsp").forward(request, response);
			
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addMenu(HttpServletRequest request, HttpServletResponse response) {
		Menu menu = BeanUtilMap2Bean.Map2Bean(request, Menu.class);
		bs.addMenu(menu);
		try {
			request.getRequestDispatcher("/manager/addMenu.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//查询出所有的菜单
	private void listAllMenu(HttpServletRequest request, HttpServletResponse response) {
		List<Menu> menus = bs.findAllMenu();
		request.setAttribute("menus", menus);
		try {
			request.getRequestDispatcher("/manager/listMenus.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

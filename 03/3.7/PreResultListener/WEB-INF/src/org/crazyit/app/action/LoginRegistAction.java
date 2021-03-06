package org.crazyit.app.action;

import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.interceptor.PreResultListener;
/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */

public class LoginRegistAction
	extends ActionSupport
{
	// 封装用户请求参数的两个成员变量
	private String username;
	private String password;
	// username的setter和getter方法
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	// password的getter和setter方法
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}

	// Action包含的注册控制逻辑
	public String regist() throws Exception
	{
		ActionContext.getContext().getSession()
			.put("user" , getUsername());
		addActionMessage("恭喜您," + getUsername() + ",您已经注册成功！");
		return SUCCESS;
	}
	// Action默认包含的控制逻辑
	public String execute() throws Exception
	{
		ActionInvocation invocation = ActionContext
			.getContext().getActionInvocation();
		invocation.addPreResultListener(new PreResultListener()
		{
			public void beforeResult(ActionInvocation invocation,
				String resultCode)
			{
				System.out.println("返回的逻辑视图名字为："
					+ resultCode);
				// 在返回Result之前加入一个额外的数据。
				invocation.getInvocationContext().put("extra"
					, new java.util.Date() + "由"
					+ resultCode + "逻辑视图名转入");
				// 也可加入日志等
			}
		});
		if (getUsername().equals("crazyit.org")
			&& getPassword().equals("leegang") )
		{
			ActionContext.getContext().getSession()
				.put("user" , getUsername());
			addActionMessage("欢迎," + getUsername() + ",您已经登录成功！");
			return SUCCESS;
		}
		return ERROR;
	}
}
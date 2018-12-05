package com.ujiuye.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import com.baidu.ueditor.ActionEnter;
import com.baidu.ueditor.ConfigManager;

public class ActionEnterExt extends ActionEnter {

	public ActionEnterExt(HttpServletRequest request, String rootPath) {
		super(request, rootPath);
	}

	public void configUploadPath() {
		try {
			// 读取父类的configManager的值，读之前改变private访问限制
			Field field1 = getClass().getSuperclass().getDeclaredField("configManager");
			field1.setAccessible(true);
			ConfigManager configManager = (ConfigManager) field1.get(this);
			// 读取父类的configManager的属性rootPath的值，读之前改变private final访问限制
			Field field2 = configManager.getClass().getDeclaredField("rootPath");
			field2.setAccessible(true);
			Field modifiersField = Field.class.getDeclaredField("modifiers");
			modifiersField.setAccessible(true);
			modifiersField.setInt(field2, field2.getModifiers() & ~Modifier.FINAL);
			// 读取ueditor的配置文件中的uploadFileRootPath，即保存的绝对路径，
			// 将该值修改为上面的rootPath的值，ueditor依赖这个值保存文件与图片
			System.out.println("rootPath原值：" + field2.get(configManager));
			JSONObject jsonCofig = configManager.getAllConfig();
			String uploadFileRootPath = jsonCofig.getString("uploadFileRootPath");
			field2.set(configManager, uploadFileRootPath);
			System.out.println("rootPath新值：" + field2.get(configManager));

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}

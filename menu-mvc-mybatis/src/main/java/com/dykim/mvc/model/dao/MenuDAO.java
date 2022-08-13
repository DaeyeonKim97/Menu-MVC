package com.dykim.mvc.model.dao;

import java.util.List;

import com.dykim.mvc.model.dto.MenuDTO;
import com.dykim.mvc.model.dto.CategoryAndMenuDTO;
import com.dykim.mvc.model.dto.CategoryDTO;
import com.dykim.mvc.model.dto.MenuAndCategoryDTO;

public interface MenuDAO {

	List<MenuDTO> selectAllMenu();
	
	List<MenuAndCategoryDTO> selectAllMenuWithCategory();

	MenuDTO selectMenuByMenuCode(int menuCode);

	CategoryAndMenuDTO selectMenuByCategoryCode(int categoryCode);
	
	int insertMenu(MenuDTO menu);
	
	int updateMenu(MenuDTO menu);
	
	int deleteMenu(int menuCode);
	
	List<CategoryDTO> selectAllCategory();
	
	int insertCategory(CategoryDTO category);
	
	
}
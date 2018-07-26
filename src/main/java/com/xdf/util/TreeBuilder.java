package com.xdf.util;

import java.util.ArrayList;
import java.util.List;

//import com.tradetuber.hiwi.web.vo.CategoryVo;

/**
 * 树形构建器
 * @author justin
 * @since 2018年5月17日
 */
public class TreeBuilder {

	/**
	 * category递归， 构建树形数据结构 根节点
	 * @param
	 * @return
	 */
	/*public List<CategoryVo> categoryVoTree(List<CategoryVo> nodes){
		List<CategoryVo> tree = new ArrayList<CategoryVo>();
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).getParentid() == null || nodes.get(i).getParentid() == 0) {
				CategoryVo root = nodes.get(i);
				this.setCategoryVoChild(nodes, root);
				tree.add(root);
			}
		}
		return tree;
	}*/
	/**
	 * category递归， 构建树形数据结构 子节点
	 * @param
	 * @return
	 */
/*	private void setCategoryVoChild(List<CategoryVo> nodes, CategoryVo parent){
		for (int i = 0; i < nodes.size(); i++) {
			Integer pid = nodes.get(i).getParentid();
			Integer id = parent.getCategoryid();
			if (pid != null && pid.equals(id)) {
				if (parent.getChildren() == null) 
					parent.setChildren(new ArrayList<CategoryVo>());
				parent.getChildren().add(nodes.get(i));
				this.setCategoryVoChild(nodes, nodes.get(i));
			}
		}
	}*/
}

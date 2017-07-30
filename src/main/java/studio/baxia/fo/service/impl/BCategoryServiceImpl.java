package studio.baxia.fo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.baxia.fo.common.CommonConstant;
import studio.baxia.fo.dao.IArticleDao;
import studio.baxia.fo.dao.ICategoryDao;
import studio.baxia.fo.pojo.Category;
import studio.baxia.fo.service.IBCategoryService;
import studio.baxia.fo.util.ReturnUtil;
import studio.baxia.fo.vo.CategoryVo;

import java.util.List;

/**
 * Created by Pan on 2016/12/4.
 */
@Service("categoryService")
public class BCategoryServiceImpl implements IBCategoryService {
    @Autowired
    private ICategoryDao iCategoryDao;
    @Autowired
    private IArticleDao iArticleDao;
    @Override
    public Boolean add(Category category) {
        Category tempCategory = iCategoryDao.selectByName(category.getName(),CommonConstant.PROJECT_ALL);
        if(null!=tempCategory){
            return false;
        }
        Integer result = iCategoryDao.insert(category);
        return ReturnUtil.returnResult(result);
    }

    @Override
    public Boolean edit(Category category) {
        Category tempCategory = iCategoryDao.selectByPrimaryKey(category);
        if(null==tempCategory){
            return false;
        }
        Integer result = iCategoryDao.updateByPrimaryKey(category);
        return ReturnUtil.returnResult(result);
    }

    @Override
    public Boolean deleteById(int categoryId) {
        Category cIdCategory = iCategoryDao.selectByPrimaryKey(categoryId);
        if (cIdCategory.getName().equals(CommonConstant.NEW_NO_NAME_CATEGORY)) {
            return false;
        } else {
            Category cNameCategory = iCategoryDao
                    .selectByName(CommonConstant.NEW_NO_NAME_CATEGORY,CommonConstant.PROJECT_ALL);
            Integer newCategoryId = null;
            if (cNameCategory == null) {
                Category newCategory = new Category();
                newCategory.setName(CommonConstant.NEW_NO_NAME_CATEGORY);
                newCategory
                        .setParentId(CommonConstant.CATEGORY_DEFAULT_PARENT_ID);
                Integer result = iCategoryDao.insert(newCategory);
                newCategoryId = newCategory.getId();
            } else {
                newCategoryId = cNameCategory.getId();
            }
            Integer result1 = iArticleDao.updateCategoryId(categoryId,
                    newCategoryId);
            Integer result2 = iCategoryDao.deleteByPrimaryKey(categoryId);
            return ReturnUtil.returnResult(result2);
        }
    }

    @Override
    public List<Category> getAllBy() {
        List<Category> result = iCategoryDao.selectAll();
        return result;
    }

    @Override
    public List<CategoryVo> getAllVoBy(Integer articleStatus,boolean status) {
        List<CategoryVo> result = iCategoryDao.selectVoBy(articleStatus,status);
        return result;
    }

    @Override
    public Category getById(int categoryId, boolean status) {
        Category query = new Category();
        query.setId(categoryId);
        query.setStatus(status);
        Category result = iCategoryDao.selectOne(query);
        return result;
    }

}

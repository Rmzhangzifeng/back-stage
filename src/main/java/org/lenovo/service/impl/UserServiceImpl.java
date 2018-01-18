package org.lenovo.service.impl;


import org.lenovo.dateBaseSetting.ReadOnlyConnection;
import org.lenovo.dao.UserDao;
import org.lenovo.pojo.Tree;
import org.lenovo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<Tree> queryTree(String pid){
        List<Tree> aa=queryTreesss(pid);
        return aa;
    }

    @ReadOnlyConnection
    public List<Tree> queryTreesss(String pid) {
        List<Tree> trees = userDao.queryByPid(pid);
        if(trees != null && trees.size()>0){
            for (int i = 0; i < trees.size(); i++) {
                List<Tree> trees2 = queryTree(trees.get(i).getId());
                trees.get(i).setNodes(trees2);
            }
        }
        return trees;
    }
}

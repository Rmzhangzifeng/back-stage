package org.lenovo.service;


import org.lenovo.pojo.Tree;

import java.util.List;

public interface UserService {




    List<Tree> queryTree(String pid);
}

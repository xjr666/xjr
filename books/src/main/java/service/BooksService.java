package service;

import java.util.List;

import pojo.Books;
import pojo.PageInfo;

public interface BooksService {
public PageInfo showUser(int fwaccess,String pageNumberStr,String pageSizeStr);
public PageInfo showBooks(int fwaccess,String in_b_name,String pageNumberStr,String pageSizeStr);
public PageInfo sousuo(String b_name,String pageNumberStr,String pageSizeStr);
public int insbook(Books books);
public PageInfo showdeletebook(int access,String name,String pageNumberStr,String pageSizeStr);
public int deletebook(int b_id);
}

package dao;

import entity.memo;

public interface MemoDao {
    void addMemo(memo Memo);
    void deleMemo(String MemoId);
    memo[] findMemoBN(String Title);
    memo findMemoBI(String MemoId);
    memo[] allMemo();
    void changeMemo(memo Memo);
}

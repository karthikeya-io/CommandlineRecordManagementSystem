package Interfaces;
import java.util.List;

/**
 * CRUDable
 */
public interface CRUDable<T> {
    void create();
    void insert(T a);
    void update(T a);
    void delete();
    List<T> printAll();
    List<T> printByID(int id);
}
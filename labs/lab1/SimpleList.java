import java.lang.*;

public interface SimpleList<T> {
   void add(T element);
   void add(int index, T element);
   T get(int index);
   T remove(int index);
   int size();
}










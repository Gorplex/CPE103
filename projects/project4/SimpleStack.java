/*SimpleStack Interface
 *
 *@author John Thomsen
 *@version project4
 */

public interface SimpleStack<T> {
   T peek();
   T pop();
   void push(T element);
   int size();
}

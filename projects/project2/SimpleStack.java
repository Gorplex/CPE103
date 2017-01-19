/*SimpleStack Interface
 *
 *@author John Thomsen
 *@version lab3
 */

public interface SimpleStack<T> {
   T peek();
   T pop();
   void push(T element);
   int size();
}

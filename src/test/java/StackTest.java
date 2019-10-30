import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public final class StackTest {

    private Stack stack;

    @Before
    public void setUp() {
        this.stack = new Stack(2);
    }

    @Test
    public void createAStack_isEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void pushToAStack_isNotEmpty() {
        this.stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test(expected = Stack.CannotPeekOrPopAnEmptyStack.class)
    public void popFromAnEmptyStack_throwCannotPopAnEmptyStack() {
        this.stack.pop();
    }


    @Test
    public void pushAndPop_isEmpty() {
        this.stack.push(1);
        this.stack.pop();
        assertTrue(this.stack.isEmpty());
    }

    @Test
    public void push2TimesAndPop_isNotEmpty() {
        this.stack.push(1);
        this.stack.push(2);
        this.stack.pop();
        assertFalse(this.stack.isEmpty());
    }

    @Test
    public void push2TimesAndPop2Times_isEmpty() {
        this.stack.push(1);
        this.stack.push(2);
        this.stack.pop();
        this.stack.pop();
        assertTrue(this.stack.isEmpty());
    }

    @Test
    public void pushAndPop_returnSameResult() {
        this.stack.push(1);
        assertEquals(1, this.stack.pop());
        this.stack.push(2);
        assertEquals(2, this.stack.pop());
    }

    @Test
    public void pushTwoElementsAndPopTwoElements_worksAsLIFO() {
        this.stack.push(99);
        this.stack.push(98);
        assertEquals(98, this.stack.pop());
        assertEquals(99, this.stack.pop());
    }

    @Test(expected = Stack.CannotPushMoreThanTheSize.class)
    public void pushTooManyElements_throwsCannotPushMoreThanTheSize() {
        this.stack.push(1);
        this.stack.push(2);
        this.stack.push(3);
    }

    @Test
    public void pushAndPeek_isNotEmpty() {
        this.stack.push(1);
        this.stack.peek();
        assertFalse(this.stack.isEmpty());
    }

    @Test(expected = Stack.CannotPeekOrPopAnEmptyStack.class)
    public void peekFromAnEmptyStack_throwCannotPopAnEmptyStack() {
        this.stack.peek();
    }


    @Test
    public void pushAndPeek_returnsTheValue() {
        this.stack.push(1);
        assertEquals(1, this.stack.peek());
    }

}

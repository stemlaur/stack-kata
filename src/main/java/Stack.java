public final class Stack {
    private final int[] elements;
    private int numberOfElements = 0;

    public Stack(final int size) {
        this.elements = new int[size];
    }

    public boolean isEmpty() {
        return this.numberOfElements == 0;
    }

    public void push(final int element) throws CannotPushMoreThanTheSize {
        if (this.elements.length <= this.numberOfElements) {
            throw new CannotPushMoreThanTheSize();
        }
        elements[this.numberOfElements++] = element;
    }

    public int pop() throws CannotPeekOrPopAnEmptyStack {
        if (isEmpty()) {
            throw new CannotPeekOrPopAnEmptyStack();
        }
        return elements[--this.numberOfElements];
    }

    public int peek() throws CannotPeekOrPopAnEmptyStack {
        if (isEmpty()) {
            throw new CannotPeekOrPopAnEmptyStack();
        }
        return elements[this.numberOfElements - 1];
    }

    public static class CannotPeekOrPopAnEmptyStack extends RuntimeException {
    }

    public static class CannotPushMoreThanTheSize extends RuntimeException {
    }
}

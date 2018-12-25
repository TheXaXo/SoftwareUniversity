import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.function.Consumer;

public class Tree<T> {
    private T value;
    private Tree<T>[] children;

    public Tree(T value) {
        this(value, null);
    }

    public Tree(T value, Tree<T>... children) {
        this.value = value;
        this.children = children;
    }

    // append output to builder
    public String print(int indent, StringBuilder builder) {
        for (int i = 0; i < indent; i++) {
            builder.append(" ");
        }

        builder.append(this.value).append("\n");

        if (this.children == null) {
            return builder.toString();
        }

        for (Tree<T> child : this.children) {
            child.print(indent + 2, builder);
        }

        return builder.toString();
    }

    public void each(Consumer<T> consumer) {
        consumer.accept(this.value);

        if (this.children == null) {
            return;
        }

        for (Tree<T> child : this.children) {
            child.each(consumer);
        }
    }

    public Iterable<T> orderDFS() {
        List<T> items = new ArrayList<>();

        this.dfs(this, items);

        return items;
    }

    private void dfs(Tree<T> tree, List<T> items) {
        if (tree.children == null) {
            items.add(tree.value);
            return;
        }

        for (Tree<T> child : tree.children) {
            dfs(child, items);
        }

        items.add(tree.value);
    }

    public Iterable<T> orderBFS() {
        List<T> items = new ArrayList<>();
        Deque<Tree<T>> treesQueue = new ArrayDeque<>();

        treesQueue.addLast(this);

        while (!treesQueue.isEmpty()) {
            Tree<T> currentTree = treesQueue.removeFirst();
            items.add(currentTree.value);

            if (currentTree.children == null) {
                continue;
            }

            for (Tree<T> child : currentTree.children) {
                treesQueue.addLast(child);
            }

        }

        return items;
    }
}
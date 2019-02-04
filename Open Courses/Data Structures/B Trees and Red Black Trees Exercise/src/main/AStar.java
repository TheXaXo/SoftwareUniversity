package main;

import java.util.*;

public class AStar {
    private char[][] map;

    public AStar(char[][] map) {
        this.map = map;
    }

    public static int getH(Node current, Node goal) {
        int deltaX = Math.abs(current.getCol() - goal.getCol());
        int deltaY = Math.abs(current.getRow() - goal.getRow());

        return deltaX + deltaY;
    }

    public Iterable<Node> getPath(Node start, Node goal) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.enqueue(start);

        Map<Node, Integer> nodeCost = new HashMap<>();
        nodeCost.put(start, 1);

        Map<Node, Node> nodeParent = new HashMap<>();
        nodeParent.put(start, null);

        while (queue.size() != 0) {
            Node current = queue.dequeue();

            if (current.equals(goal)) {
                break;
            }

            List<Node> neighbours = this.getNeighbours(current);
            int newCost = nodeCost.get(current) + 1;

            for (Node neighbour : neighbours) {
                if (!nodeCost.containsKey(neighbour) || newCost < nodeCost.get(neighbour)) {
                    nodeCost.put(neighbour, newCost);
                    neighbour.setF(newCost + getH(neighbour, goal));
                    queue.enqueue(neighbour);
                    nodeParent.put(neighbour, current);
                }
            }
        }

        return this.reconstructPath(start, goal, nodeParent);
    }

    private List<Node> getNeighbours(Node node) {
        List<Node> neighbours = new ArrayList<>();

        int nodeUpRow = node.getRow() - 1;
        int nodeDownRow = node.getRow() + 1;
        int nodeLeftCol = node.getCol() - 1;
        int nodeRightCol = node.getCol() + 1;

        if (nodeUpRow >= 0 && !this.isWall(nodeUpRow, node.getCol())) {
            neighbours.add(new Node(nodeUpRow, node.getCol()));
        }

        if (nodeDownRow < this.map.length && !this.isWall(nodeDownRow, node.getCol())) {
            neighbours.add(new Node(nodeDownRow, node.getCol()));
        }

        if (nodeLeftCol >= 0 && !this.isWall(node.getRow(), nodeLeftCol)) {
            neighbours.add(new Node(node.getRow(), nodeLeftCol));
        }

        if (nodeRightCol < this.map[0].length && !this.isWall(node.getRow(), nodeRightCol)) {
            neighbours.add(new Node(node.getRow(), nodeRightCol));
        }

        return neighbours;
    }

    private boolean isWall(int row, int col) {
        return this.map[row][col] == 'W';
    }

    private Iterable<Node> reconstructPath(Node start, Node goal, Map<Node, Node> nodeParent) {
        List<Node> nodes = new ArrayList<>();

        if (!nodeParent.containsKey(goal)) {
            nodes.add(start);

            return nodes;
        }

        nodes.add(goal);

        Node current = nodeParent.get(goal);

        while (current != null) {
            nodes.add(current);
            current = nodeParent.get(current);
        }

        Collections.reverse(nodes);

        return nodes;
    }
}
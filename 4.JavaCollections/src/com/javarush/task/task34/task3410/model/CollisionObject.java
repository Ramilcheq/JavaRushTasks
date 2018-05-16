package com.javarush.task.task34.task3410.model;

public abstract class CollisionObject extends GameObject {
    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        int d = Model.FIELD_CELL_SIZE;
        switch (direction) {
            case UP:
                return (this.x == gameObject.x && this.y - d == gameObject.y);
            case DOWN:
                return (this.x == gameObject.x && this.y + d == gameObject.y);
            case LEFT:
                return (this.x - d == gameObject.x && this.y == gameObject.y);
            case RIGHT:
                return (this.x + d == gameObject.x && this.y == gameObject.y);
        }
        return false;
    }
}

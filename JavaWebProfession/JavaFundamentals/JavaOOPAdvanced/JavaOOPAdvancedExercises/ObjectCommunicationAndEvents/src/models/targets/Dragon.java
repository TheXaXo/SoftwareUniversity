package models.targets;

import logger.Handler;

public class Dragon extends AbstractTarget {

    public Dragon(String id, int hp, int reward, Handler handler) {
        super(id, hp, reward, handler);
    }
}
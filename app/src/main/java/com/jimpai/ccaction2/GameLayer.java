package com.jimpai.ccaction2;

import org.cocos2d.actions.interval.CCJumpBy;
import org.cocos2d.actions.interval.CCMoveBy;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

/**
 * Created by jimpai on 15/4/24.
 */
public class GameLayer extends CCLayer {
    CCSprite playerA;
    CCSprite playerB;

    public GameLayer() {
        playerA = CCSprite.sprite("player.png");
        playerB = CCSprite.sprite("player.png");
        this.addChild(playerA);
        this.addChild(playerB);

        CGPoint cgPoint = CGPoint.ccp(400, 400);
        playerA.setPosition(cgPoint);
        playerB.setPosition(cgPoint);

        CGPoint deltaPoint = CGPoint.ccp(0, 200);
        CGPoint targetPoint = CGPoint.ccpAdd(cgPoint, deltaPoint);

        playerA.setPosition(targetPoint);

        CGPoint subPoint = CGPoint.ccp(200, 300);
        CGPoint tgPoint = CGPoint.ccpSub(targetPoint, subPoint);
        playerA.setPosition(tgPoint);

        CGPoint newPoint = CGPoint.ccpMult(tgPoint, 2);
        playerA.setPosition(newPoint);

        CGPoint anotherPoint = CGPoint.ccpNormalize(tgPoint);
        playerA.setPosition(anotherPoint);

        CGPoint onePoint = CGPoint.ccp(500, 300);
        CCMoveBy moveBy = CCMoveBy.action(5, onePoint);
        playerA.runAction(moveBy);

        CGPoint jumpPoint = CGPoint.ccp(300, 100);
        CCJumpBy jumpBy = CCJumpBy.action(5, deltaPoint, 500, 5);
        playerA.runAction(jumpBy);
    }
}

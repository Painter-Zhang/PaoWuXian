package com.zhangpeiyuan.paowuxian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageButton;

import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.animation.AnimatorProxy;
import static com.nineoldandroids.view.ViewPropertyAnimator.animate;


public class AnimationActivity extends Activity implements View.OnClickListener{

    protected static final int START_ANIMATION1 = 0;
    protected static final int START_ANIMATION2 = 1;
    protected static final int START_ANIMATION3 = 2;
    protected static final int START_ANIMATION4 = 3;
    private ImageButton people, mail, cellphone, camera;
    private AnimatorProxy mailproxy;
    private AnimatorProxy cellphoneproxy;
    private AnimatorProxy cameraproxy;
    private AnimatorProxy peopleproxy;
    private ObjectAnimator anim1, anim2, anim3, anim4;

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case START_ANIMATION1:
                    anim1.start();
                    animate(people).setDuration(1000);
                    animate(people).rotationYBy(360);
                    break;
                case START_ANIMATION2:
                    anim2.start();
                    animate(mail).setDuration(1000);
                    animate(mail).rotationYBy(360);
                    break;
                case START_ANIMATION3:
                    anim3.start();
                    animate(cellphone).setDuration(1000);
                    animate(cellphone).rotationYBy(360);
                    break;
                case START_ANIMATION4:
                    anim4.start();
                    animate(camera).setDuration(1000);
                    animate(camera).rotationYBy(360);
                    break;
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        people = (ImageButton) findViewById(R.id.people);
        mail = (ImageButton) findViewById(R.id.mail);
        cellphone = (ImageButton) findViewById(R.id.cellphone);
        camera = (ImageButton) findViewById(R.id.camera);

        initAnimation();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void initAnimation() {

        peopleproxy = AnimatorProxy.wrap(people);
        AnimatorPath path1 = new AnimatorPath();
        path1.moveTo(0, 0);
//        path.lineTo(0, 300);直线轨迹
        path1.curveTo(-200, -200, -200, -200, -250, 200);

        anim1 = ObjectAnimator.ofObject(this, "peopleLoc",
                new PathEvaluator(), path1.getPoints().toArray());
        anim1.setDuration(1000);
        handler.sendEmptyMessageDelayed(START_ANIMATION1, 500);

        mailproxy = AnimatorProxy.wrap(mail);
        AnimatorPath path2 = new AnimatorPath();
        path2.moveTo(0, 0);
        path2.curveTo(200, -200, 200, -200, 250, 200);

        anim2 = ObjectAnimator.ofObject(this, "mailLoc",
                new PathEvaluator(), path2.getPoints().toArray());
        anim2.setDuration(1000);
        handler.sendEmptyMessageDelayed(START_ANIMATION2, 800);

        cellphoneproxy = AnimatorProxy.wrap(cellphone);
        AnimatorPath path3 = new AnimatorPath();
        path3.moveTo(0, 0);
        path3.curveTo(-70, -400, -70, -400, -100, 290);

        anim3 = ObjectAnimator.ofObject(this, "cellphoneLoc",
                new PathEvaluator(), path3.getPoints().toArray());
        anim3.setDuration(1000);
        handler.sendEmptyMessageDelayed(START_ANIMATION3, 1000);

        cameraproxy = AnimatorProxy.wrap(camera);
        AnimatorPath path4 = new AnimatorPath();
        path4.moveTo(0, 0);
        path4.curveTo(70, -350, 70, -350, 100, 290);

        anim4 = ObjectAnimator.ofObject(this, "cameraLoc",
                new PathEvaluator(), path4.getPoints().toArray());
        anim4.setDuration(1000);
        handler.sendEmptyMessageDelayed(START_ANIMATION4, 1300);
    }


    public void setPeopleLoc(PathPoint newLoc) {
        peopleproxy.setTranslationX(newLoc.mX);
        peopleproxy.setTranslationY(newLoc.mY);
    }

    public void setMailLoc(PathPoint newLoc) {
        mailproxy.setTranslationX(newLoc.mX);
        mailproxy.setTranslationY(newLoc.mY);
    }

    public void setCellphoneLoc(PathPoint newLoc) {
        cellphoneproxy.setTranslationX(newLoc.mX);
        cellphoneproxy.setTranslationY(newLoc.mY);
    }

    public void setCameraLoc(PathPoint newLoc) {
        cameraproxy.setTranslationX(newLoc.mX);
        cameraproxy.setTranslationY(newLoc.mY);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        
        switch (v.getId()){
            case R.id.people:
                intent = new Intent(this,ChartActivity.class);
                break;
            case R.id.cellphone:
                
                break;
            case R.id.mail:
                
                break;
            case R.id.camera:
                
                break;
        }
    }
}
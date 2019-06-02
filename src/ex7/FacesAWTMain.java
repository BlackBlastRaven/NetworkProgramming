//FacesAWTMain 目標 インナークラスのFaceObjクラスを作ってみよう。描画処理を移譲してください。
//3x3　の顔を描画してください。色などもぬってオリジナルな楽しい顔にしてください。

package ex7;


import java.awt.*;
import java.awt.event.*;

public class FacesAWTMain {

    public static void main(String[] args) {
        new FacesAWTMain();
    }

    FacesAWTMain() {
        FaceFrame f = new FaceFrame();
        f.setSize(800, 800);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

    // インナークラスを定義
    class FaceFrame extends Frame {

        private int w;
        private int h;
        private int xStart;
        private int yStart;
        private FaceObj faceObj1;
        FaceObj[] faceObjects = new FaceObj[9];

        FaceFrame() {
            //faceObj1 = new FaceObj();
        }

        public void paint(Graphics g) {
            // この中には、g.drawLine というのは入ってこない
            // Graphicsクラス(型のようなもの---今は--)のgという変数はメソッドに渡す
            w = 200;
            h = 200;
            xStart = 50;
            yStart = 50;

            //FaceObj fobj = new FaceObj(200,200,50,50);
            //FaceObj faceObj1 = new FaceObj(50, 50, -60, 90, 30, 45, 20, 0, 55, 70);
            //fobj.drawRim();
/*
            for (FaceObj faceObj : faceObjects) {
                faceObj = new FaceObj(50, 50, -60, 90, 30, 45, 20, 0, 55, 70);
                faceObj.drawAll(g);
            }
*/
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    faceObjects[j] = new FaceObj((j + 1) * 200, (i + 1) * 200, -50 + (int) (Math.random() * 20), 90, 30, 45, 20, 0, 55, 70);
                    faceObjects[j].drawAll(g);
                }
            }

            /*
            drawRim(g);
            drawBrow(g, 30);
            drawEye(g, 35);
            drawNose(g, 40);
            drawMouth(g, 100);

             */
            //faceObj1.drawAll(g);
        }
    }//FaceFrame end

    //Faceクラスを作ってみよう。
    private class FaceObj {
        /*
        int w = 200;
        int h = 200;
        int xStart = 50;
        int yStart = 50;
*/
        int centerX;
        int centerY;

        int rimLeftTopX;
        int rimLeftTopY;

        int rimHeight;
        int rimWidth;

        int eyeY;
        int eyeWidth;
        int eyeR;

        int noseWidth;
        int noseHeight;

        int mouthX;
        int mouthY;
        int mouthWidth;

        //int mouthLeftX;
        //int mouthLeftY;

        //int mouthCenterX;
        //int mouthCenterY;

        //int mouthRightX;
        //int mouthRightY;


        /*
        輪郭の開始線、輪郭の縦幅と横幅
        (目のx,y座標,大きさ)これが２つ
        鼻の３座標(三角形)
        口の開始点,中間点,終了点それぞれの座標


        輪郭の左上の位置
        輪郭の高さと幅
        目の幅と高さと大きさ
        鼻の高さと幅
        口の高さと幅

         */
        public FaceObj(int rimLeftTopX, int rimLeftTopY, int eyeY, int eyeWidth, int eyeR, int noseHeight, int noseWidth, int mouthX, int mouthY, int mouthWidth) {
            this.rimHeight = 200;
            this.rimWidth = 200;
            this.centerX = rimLeftTopX + (rimWidth / 2);
            this.centerY = rimLeftTopY + (rimHeight / 2);

            this.rimLeftTopX = rimLeftTopX;
            this.rimLeftTopY = rimLeftTopY;
            this.eyeY = eyeY + centerY;
            this.eyeR = eyeR;
            this.eyeWidth = eyeWidth;
            this.noseHeight = noseHeight;
            this.noseWidth = noseWidth;
            this.mouthX = mouthX + centerX;
            this.mouthY = mouthY + centerY;
            this.mouthWidth = mouthWidth;
        }

        //public FaceObj(int rimLeftTopX, int rimLeftTopY)

        public void drawAll(Graphics g) {
            centerX = rimLeftTopX + (rimWidth / 2);
            drawRim(g);
            //drawBrow(g, 30);
            drawEye(g, eyeY, eyeWidth, eyeR);
            drawNose(g, noseHeight, noseWidth);
            drawMouth(g, mouthX, mouthY, mouthWidth);
        }


        public void drawRim(Graphics g) {  // wが横幅、hが縦幅
            g.drawLine(rimLeftTopX, rimLeftTopY, rimLeftTopX + rimWidth, rimLeftTopY);
            g.drawLine(rimLeftTopX + rimWidth, rimLeftTopY, rimLeftTopX + rimWidth, rimLeftTopY + rimHeight);
            g.drawLine(rimLeftTopX + rimWidth, rimLeftTopY + rimHeight, rimLeftTopX, rimLeftTopY + rimHeight);
            g.drawLine(rimLeftTopX, rimLeftTopY + rimHeight, rimLeftTopX, rimLeftTopY);
        }


        public void drawBrow(Graphics g, int bx) { // xは目の幅 呼ばれる方(=定義する方)

        }

        public void drawNose(Graphics g, int noseHeight, int noseWidth) { // xは鼻の長さ
            g.drawLine(centerX, centerY - (noseHeight / 2), centerX + (noseWidth / 2), centerY + (noseHeight / 2));
            g.drawLine(centerX + (noseWidth / 2), centerY + (noseHeight / 2), centerX - (noseWidth / 2), centerY + (noseHeight / 2));
            g.drawLine(centerX - (noseWidth / 2), centerY + (noseHeight / 2), centerX, centerY - (noseHeight / 2));
        }

        public void drawEye(Graphics g, int eyeY, int eyeWidth, int eyeR) {
            g.drawOval(centerX - (eyeWidth / 2) - (eyeR / 2), eyeY, eyeR, eyeR);
            g.drawOval(centerX + (eyeWidth / 2) - (eyeR / 2), eyeY, eyeR, eyeR);
        }

        public void drawMouth(Graphics g, int mouthX, int mouthY, int mouthWidth) {
            g.drawLine(mouthX - (mouthWidth / 2), mouthY, mouthX + (mouthWidth / 2), mouthY);
        }

    }

}//Faces class end





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
        private FaceObj faceObj2;
        private FaceObj faceObj3;
        private FaceObj faceObj4;
        private FaceObj faceObj5;
        private FaceObj faceObj6;
        private FaceObj faceObj7;
        private FaceObj faceObj8;
        private FaceObj faceObj9;

        FaceFrame() {
            faceObj1 = new FaceObj(50,50,250,50,50,250,250,250,100,100,20,200,100,20,100,90,110,60,200,150,170,230,200);
            faceObj2 = new FaceObj(250,50,500,50,250,50,500,50,20,60,10,160,60,10,100,90,110,10,180,100,170,190,180);
            faceObj3 = new FaceObj(200,40,200,240,0,40,0,240,20,60,10,160,60,10,100,90,110,10,180,100,170,190,180);
            faceObj4 = new FaceObj(200,40,200,240,0,40,0,240,20,60,10,160,60,10,100,90,110,10,180,100,170,190,180);
            faceObj5 = new FaceObj(200,40,200,240,0,40,0,240,20,60,10,160,60,10,100,90,110,10,180,100,170,190,180);
            faceObj6 = new FaceObj(200,40,200,240,0,40,0,240,20,60,10,160,60,10,100,90,110,10,180,100,170,190,180);
            faceObj7 = new FaceObj(200,40,200,240,0,40,0,240,20,60,10,160,60,10,100,90,110,10,180,100,170,190,180);
            faceObj8 = new FaceObj(200,40,200,240,0,40,0,240,20,60,10,160,60,10,100,90,110,10,180,100,170,190,180);
            faceObj9 = new FaceObj(200,40,200,240,0,40,0,240,20,60,10,160,60,10,100,90,110,10,180,100,170,190,180);

        }

        public void paint(Graphics g) {
            // この中には、g.drawLine というのは入ってこない
            // Graphicsクラス(型のようなもの---今は--)のgという変数はメソッドに渡す
            w = 200;
            h = 200;
            xStart = 50;
            yStart = 50;

            //FaceObj fobj = new FaceObj(200,200,50,50);
            //FaceObj faceObj2 = new FaceObj(200,200,250,50);
            //fobj.drawRim();

            /*
            drawRim(g);
            drawBrow(g, 30);
            drawEye(g, 35);
            drawNose(g, 40);
            drawMouth(g, 100);

             */
            faceObj1.drawAll(g);
            faceObj2.drawAll(g);

        }
/*
        public void drawRim(Graphics g) {  // wが横幅、hが縦幅
            g.drawLine(50, 50, 50 + w, 50);
            g.drawLine(50, 50, 50, 50 + h);
            g.drawLine(50, 50 + h, 50 + w, 50 + h);
            g.drawLine(50 + w, 50, 50 + w, 50 + h);
        }

        public void drawBrow(Graphics g, int bx) { // xは目の幅 呼ばれる方(=定義する方)

        }

        public void drawNose(Graphics g, int nx) { // xは鼻の長さ

        }

        public void drawEye(Graphics g, int r) { // rは目の半径
            g.drawOval(xStart + 45, yStart + 65, r, r);

        }

        public void drawMouth(Graphics g, int mx) { // xは口の幅
            int xMiddle = 50 + w / 2;
            int yMiddle = 50 + h - 30;
            g.drawLine(xMiddle - mx / 2, yMiddle, xMiddle + mx / 2, yMiddle);
        }
*/
    }//FaceFrame end

    //Faceクラスを作ってみよう。
    private class FaceObj {
        /*
        int w = 200;
        int h = 200;
        int xStart = 50;
        int yStart = 50;
*/
        int rimRightTopX;
        int rimRightTopY;

        int rimRightBottomX;
        int rimRightBottomY;

        int rimLeftTopX;
        int rimLeftTopY;

        int rimLeftBottomX;
        int rimLeftBottomY;


        int leftEyeX;
        int leftEyeY;
        int leftEyeR;

        int rightEyeX;
        int rightEyeY;
        int rightEyeR;

        int noseTop;
        int noseLeft;
        int noseRight;

        int mouthLeftX;
        int mouthLeftY;

        int mouthCenterX;
        int mouthCenterY;

        int mouthRightX;
        int mouthRightY;

        int rimHight;
        int rimWidth;

        /*
        輪郭の開始線、輪郭の縦幅と横幅
        (目のx,y座標,大きさ)これが２つ
        鼻の３座標(三角形)
        口の開始点,中間点,終了点それぞれの座標
         */
        public FaceObj(int rimLeftTopX, int rimLeftTopY, int rimRightTopX, int rimRightTopY, int rimLeftBottomX, int rimLeftBottomY, int rimRightBottomX, int rimRightBottomY, int leftEyeX, int leftEyeY, int leftEyeR, int rightEyeX, int rightEyeY, int rightEyeR, int noseTop, int noseLeft, int noseRight, int mouthLeftX, int mouthLeftY, int mouthCenterX, int mouthCenterY, int mouthRightX, int mouthRightY) {
            this.rimRightTopX = rimRightTopX;
            this.rimRightTopY = rimRightTopY;
            this.rimRightBottomX = rimRightBottomX;
            this.rimRightBottomY = rimRightBottomY;
            this.rimLeftTopX = rimLeftTopX;
            this.rimLeftTopY = rimLeftTopY;
            this.rimLeftBottomX = rimLeftBottomX;
            this.rimLeftBottomY = rimLeftBottomY;
            this.leftEyeX = leftEyeX;
            this.leftEyeY = leftEyeY;
            this.leftEyeR = leftEyeR;
            this.rightEyeX = rightEyeX;
            this.rightEyeY = rightEyeY;
            this.rightEyeR = rightEyeR;
            this.noseTop = noseTop;
            this.noseLeft = noseLeft;
            this.noseRight = noseRight;
            this.mouthLeftX = mouthLeftX;
            this.mouthLeftY = mouthLeftY;
            this.mouthCenterX = mouthCenterX;
            this.mouthCenterY = mouthCenterY;
            this.mouthRightX = mouthRightX;
            this.mouthRightY = mouthRightY;


        }

        public void drawAll(Graphics g) {
            drawRim(g);
            drawBrow(g, 30);
            drawEye(g, leftEyeX, leftEyeY, leftEyeR, rightEyeX, rightEyeY, rightEyeR);
            drawNose(g, 40);
            drawMouth(g, mouthLeftX, mouthLeftY, mouthCenterX, mouthCenterY, mouthRightX, mouthRightY);
        }


        public void drawRim(Graphics g) {  // wが横幅、hが縦幅
            g.drawLine(rimLeftTopX, rimLeftTopY, rimLeftTopX+rimWidth, rimLeftTopY);
            g.drawLine(rimLeftTopX+rimWidth, rimLeftTopY, rimLeftTopX+rimWidth, rimLeftTopY+rimHight);
            g.drawLine(rimLeftTopX, rimLeftTopY, rimLeftTopX+rimWidth, rimLeftTopY);
            g.drawLine(rimLeftTopX, rimLeftTopY, rimLeftTopX+rimWidth, rimLeftTopY);
        }

        public void drawRim2(Graphics g) {  // wが横幅、hが縦幅
            g.drawLine(rimLeftTopX, rimLeftTopY, rimRightTopX, rimRightTopY);
            g.drawLine(rimRightTopX, rimRightTopY, rimRightBottomX, rimRightBottomY);
            g.drawLine(rimRightBottomX, rimRightBottomY, rimLeftBottomX, rimLeftBottomY);
            g.drawLine(rimLeftBottomX, rimLeftBottomY, rimLeftTopX, rimLeftTopY);
        }



        public void drawBrow(Graphics g, int bx) { // xは目の幅 呼ばれる方(=定義する方)

        }

        public void drawNose(Graphics g, int nx) { // xは鼻の長さ

        }

        public void drawEye(Graphics g, int leftEyeX, int leftEyeY, int leftEyeR, int rightEyeX, int rightEyeY, int rightEyeR) {
            g.drawOval(leftEyeX, leftEyeY, leftEyeR, leftEyeR);
            g.drawOval(rightEyeX, rightEyeY, rightEyeR, rightEyeR);
        }

        public void drawMouth(Graphics g, int mouthLeftX, int mouthLeftY, int mouthCenterX, int mouthCenterY, int mouthRightX, int mouthRightY) {
            g.drawLine(mouthLeftX, mouthLeftY, mouthCenterX, mouthCenterY);
            g.drawLine(mouthCenterX, mouthCenterY, mouthRightX, mouthRightY);
        }

    }

}//Faces class end





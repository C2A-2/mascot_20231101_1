package mascot;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Icon extends JFrame implements MouseMotionListener, MouseListener{
	ImageIcon icon = new ImageIcon("desktop.png");
	JLabel label = new JLabel(icon);
	ImageIcon icon2 = new ImageIcon("zaka.jpeg");
	JLabel label2 = new JLabel(icon);
	
	
	//int x=1080,y=480;
	
	
	
	
	
	
	
	//呼出しチェック
		int i=0;
	
	Icon() {
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		//GraphicsDevice gd = ge.getDefaultScreenDevice();
		//gd.setFullScreenWindow(frame);
		// 3, 画面のウィンドウサイズ指定はこの位置で。
		setSize(1920, 1080);
		getContentPane().setLayout(null);
		// 4, 回答の原因:aの対策
		//label指定
		label.setBounds(950, 350, 306, 150);
		
		// 枠を外す。
        setUndecorated(true);
        // 背景色を透明にする。
        setBackground(new Color(0, 0, 0, 0));
        // タスクバーのアイコンを非表示
        setType(Type.UTILITY) ;
		// 5, 回答の原因:bの対策
		getContentPane().add(label); //引数label
		
		addMouseMotionListener(this);
		addMouseListener(this);
		
		//Timer timer = new Timer();
		//timer.schedule(new MyTimer(),0,1000);
	}
	
	
	
//	class MyTimer extends TimerTask {
//        public void run(){
//        	x-=10;
//        	//y+=10;
//        	
//        	//チェック反転
//        	if(check==false) {
//        		check=true;
//        	}else {
//        		check=false;
//        	}
//        	
//        	//画像切り替え
//        	if(check==false) {
//	        	label.setBounds(x, y, 200, 200);
//	        	//label2.setVisible(false);
//	        	label.setVisible(true);
//	        	System.out.println("タイマー処理1");
//        	}else {
//        		label2.setBounds(x, y, 200, 200);
//        		//label.setVisible(false);
//	        	label2.setVisible(true);
//            	System.out.println("タイマー処理2");
//        	}
//        }
// }
	
	

	// 6, @Overrideアノテーションを付ける。
		@Override
		public void mouseDragged(MouseEvent e) {
			// 7, サイズが変わらないのであれば、setBoundsではなくsetLocationを呼び出す。
			label.setLocation(e.getPoint());
			// 8, repaintは呼び出さない。
		}

		@Override
		public void mouseMoved(MouseEvent e) {
		}
		
		@Override
		public void mouseEntered(MouseEvent e){
		    /* 処理したい内容をここに記述する */
			System.out.println("カーソルがコンポーネントに乗った");
			
			//初期値0、初回は呼び出さない
			i++;
			if(1<i) {
			new Pulldown();//.setVisible(true);
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			
		}

}

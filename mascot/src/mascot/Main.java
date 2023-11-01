package mascot;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Main extends JFrame implements MouseMotionListener, MouseListener {
	ImageIcon icon = new ImageIcon("R1.png");
	JLabel label = new JLabel(icon);
	ImageIcon icon2 = new ImageIcon("R2.png");
	JLabel label2 = new JLabel(icon2);
	ImageIcon icon3 = new ImageIcon("R3.png");
	JLabel label3 = new JLabel(icon3);
	
	
	
	//JLabel label = new JLabel("こんにちわ");
	//JFrame frame = new JFrame();
	//Timer timer1;
	Timer timer1= new Timer(true);
	TimerTask task;
	
	//座標初期位置
	int x=1080,y=480;
	
	//画像切り替えチェック
	//boolean check=true;
	int check=0;
	
	
	
	//呼出しチェック
	int i=0;
	

	public static void main(String[] args) {
		// 1, SwingUtilities.invokeLaterを使う。
		// 2, mouseExecのコンストラクタ内ではsetVisible(true);を行わない。
		SwingUtilities.invokeLater(() -> {
			new Main().setVisible(true);
		});
		
		
		
		
	    
	    
		
	}

	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		//GraphicsDevice gd = ge.getDefaultScreenDevice();
		//gd.setFullScreenWindow(frame);
		// 3, 画面のウィンドウサイズ指定はこの位置で。
		setSize(1920, 1080);
		getContentPane().setLayout(null);
		// 4, 回答の原因:aの対策
		//label指定
		label.setBounds(x, y, 200, 200);
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
		
		move();
		
		
		timer1.schedule(task, 0, 1000);
		
//		Timer timer = new Timer(true);
//		//timer.schedule(new MyTimer(),0,1000);
//		TimerTask task = new TimerTask() {

//			@Override
//			public void run() {
//				// TODO 自動生成されたメソッド・スタブ
//				System.out.println("111");
//			}
//			
//		};
	}
	
	public void move() {
		task = new TimerTask() {
        public void run(){
        	//x-=10;
        	//y+=10;
        	
        	//チェック
        	check++;
        	if(3<check) {
        		check=0;
        	}
        	
        	//画像切り替え
        	switch(check) {
        	case 1:
        		for(int I=0;I<5;I++) {
        			x-=2;
		        	label.setBounds(x, y, 200, 200);
		        	//label2.setVisible(false);
		        	getContentPane().add(label);
		        	label2.setVisible(false);
		        	label3.setVisible(false);
		        	label.setVisible(true);
		        	System.out.println("タイマー処理1");
        		}
        		break;
        	
        	case 3:
        		for(int I=0;I<5;I++) {
        			x-=2;
	        		label3.setBounds(x, y, 200, 200);
	        		//label.setVisible(false);
	        		getContentPane().add(label3);
	        		label.setVisible(false);
	        		label2.setVisible(false);
		        	label3.setVisible(true);
	            	System.out.println("タイマー処理3");
        		}
        		break;
        	
        	default:
	    		for(int I=0;I<5;I++) {
	    			x-=2;
	        		label2.setBounds(x, y, 200, 200);
	        		//label.setVisible(false);
	        		getContentPane().add(label2);
	        		label.setVisible(false);
	        		label3.setVisible(false);
		        	label2.setVisible(true);
	            	System.out.println("タイマー処理2");
	    		}
	    		break;
        }
        	
        	
    }
    
        
       
	
};

}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//コンポーネント上でクリックして離す
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//コンポーネント上でクリックする
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//マウスクリックが離されると呼出し
		x=e.getX();
		y=e.getY();
		
		if(timer1==null) {
			timer1=new Timer(true);
			move();
		timer1.schedule(task, 0, 1000);
		
		System.out.print("クリック離す");
		}
				
				
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//コンポーネントにマウスが入る
		System.out.println("カーソルがコンポーネントに乗った");
		
		 
		
		
		//初期値０、初回は呼び出さない
		i++;
		if(1<i) {
		new Pulldown();//.setVisible(true);
		}
		
		//移動停止
		if(timer1 != null){
            timer1.cancel();
            timer1 = null;
        }
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//コンポーネントからマウスが出る
		if(timer1==null) {
			timer1=new Timer(true);
			move();
			timer1.schedule(task, 0, 1000);
		}
		System.out.println("移動開始");
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//クリックしてドラッグする
		
		//移動停止
		if(timer1 != null){
			timer1.cancel();
			timer1 = null;
		}
		 
        
		 System.out.println("停止後");
		// 7, サイズが変わらないのであれば、setBoundsではなくsetLocationを呼び出す。
				switch (i){
				case 1:
					label.setLocation(e.getPoint());
				case 3:
					label3.setLocation(e.getPoint());
				default:
					label2.setLocation(e.getPoint());
				}
				// 8, repaintは呼び出さない。
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
}

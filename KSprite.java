import java.awt.*;
import java.awt.image.*;
import java.util.*;

/**
 * スプライト
 * <pre>
 * スプライトオブジェクト。
 * スプライトの概念を実現。
 * </pre>
 */
abstract public class KSprite extends KSpriteObject {

	/** パネル */
	protected KPanel panel = null;

	/** イメージ・クラス設定 */
	private static HashMap<Class, BufferedImage[]>imageThiss = new HashMap<Class, BufferedImage[]>();

	/** イメージ現在設定 */
	private BufferedImage imageThis = null;

	/** X座標 */
	protected int intX = 0;

	/** Y座標 */
	protected int intY = 0;

	/** 幅（基本） */
	protected int baseWidth = -1;

	/** 高さ（基本） */
	protected int baseHeight= -1;

	/** 表示しているクラス */
	protected Class theClass = null;

	/** 背景色 */
	private Color colorBackground = Color.black;

	/**
	 * コンストラクタ
	 * @param panel パネル
	 */
	public KSprite(KPanel panel){

		super();

		this.panel = panel;

		this.theClass = this.getClass();

		// イメージ設定
		this.imageThis = imageThiss.get(this.getClass())[0];

		// 幅（基本）設定
		this.baseWidth = this.imageThis.getWidth();

		// 高さ（基本）設定
		this.baseHeight = this.imageThis.getHeight();

	}

	/**
	 * イメージ保持
	 * <pre>
	 * イメージを保持します。毎回、イメージを呼び出すのは重い可能性があるため、保持します。
	 * staticメソッドです。
	 * </pre>
	 * @param theClass スプライトクラス
	 * @param image イメージ
	 */
	public static void setImage(Class theClass, BufferedImage image){
		KSprite.setImage(theClass, new BufferedImage[]{image});
	}

	/**
	 * イメージ保持（複数）
	 * <pre>
	 * イメージを保持します。毎回、イメージを呼び出すのは重い可能性があるため、保持します。
	 * staticメソッドです。
	 * </pre>
	 * @param theClass スプライトクラス
	 * @param images イメージ（複数）
	 */
	public static void setImage(Class theClass, BufferedImage[] images){
		KSprite.imageThiss.put(theClass, images);
	}

	/**
	 * スプライト描画
	 * <pre>
	 * 表示の必要があれば実行される。
	 * </pre>
	 */
	public void paint(Graphics g){

		// 伸縮させない場合、
		if(!panel.getStretchScreen()){

			// イメージを表示
			g.drawImage(this.imageThis, intX, intY, this.getWidth(), this.getHeight(), panel);

		// 伸縮させる場合、
		}else{

			// 描画位置を計算
			int dx1 = (int)(intX * panel.getRatioWidth());
			int dy1 = (int)(intY * panel.getRatioHeight());

			int dx2 = 0;
			int dy2 = 0;

			 // 幅（基本）、高さ（基本） が設定されていない場合、
			if(this.baseWidth == -1 && this.baseHeight == -1){

				dx2 = (int)(this.getWidth() * panel.getRatioWidth()) + dx1;
				dy2 = (int)(this.getHeight() * panel.getRatioHeight()) + dy1;

			 // 幅（基本）、高さ（基本） が設定されている場合、
			}else{

				dx2 = (int)(this.baseWidth * panel.getRatioWidth()) + dx1;
				dy2 = (int)(this.baseHeight * panel.getRatioHeight()) + dy1;

			} // end if

			g.drawImage(this.imageThis, dx1, dy1, dx2, dy2, 0, 0, this.getWidth(), this.getHeight(), panel);

		}

	} // end paint

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * 継承先で定義をしてください。
	 * </pre>
	 */
	abstract public void run();

	/**
	 * X座標取得
	 */
	public int getX(){
		return this.intX;
	}

	/**
	 * X座標設定
	 */
	public void setX(int x){
		this.intX = x;
	}

	/**
	 * Y座標取得
	 */
	public int getY(){
		return this.intY;
	}

	/**
	 * Y座標設定
	 */
	public void setY(int y){
		this.intY = y;
	}

	/**
	 * イメージ取得
	 * <pre>
	 * 現在のイメージを返却します。
	 * </pre>
	 * @return BufferedImage イメージ
	 */
	protected BufferedImage getImage(){
		// イメージをリターン
		return this.imageThis;
	}

	/**
	 * イメージ設定
	 * @imagePhase イメージフェーズ
	 */
	public void setImage(int imagePhase){
		// イメージ設定
		this.imageThis = imageThiss.get(this.getClass())[imagePhase];
	}

	/**
	 * イメージ設定
	 * @theClass スプライトクラス 自クラスと違うスプライトを指定する場合は、このメソッドを呼び出す
	 * @imagePhase イメージフェーズ
	 */
	public void setImage(Class theClass, int imagePhase){
		// クラス保持
		this.theClass = theClass;
		// イメージ設定
		this.imageThis = imageThiss.get(theClass)[imagePhase];
	}

	/**
	 * 幅取得
	 */
	public int getWidth(){
		return imageThiss.get(theClass)[0].getWidth(panel);
	}

	/**
	 * 高さ取得
	 */
	public int getHeight(){
		return imageThiss.get(theClass)[0].getHeight(panel);
	}

	/**
	 * 幅（基本）取得
	 */
	public int getBaseWidth(){
		return this.baseWidth;
	}

	/**
	 * 幅（基本）設定
	 */
	public void setBaseWidth(int x){
		this.baseWidth = x;
	}

	/**
	 * 高さ（基本）取得
	 */
	public int getBaseHeight(){
		return this.baseHeight;
	}

	/**
	 * 高さ（基本）設定
	 */
	public void setBaseHeight(int y){
		this.baseHeight = y;
	}

	/**
	 * スプライト削除
	 * <pre>
	 * 自スプライトを削除します。
	 * <pre>
	 */
	public void removeSprite(){

		// スプライトを削除
		panel.removeSprite(this);

	} // end removeSprite

	/**
	 * パネル取得
	 */
	public KPanel getKPanel(){
		return panel;
	}

}

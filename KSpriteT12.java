import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.io.*;

/**
 * 敵１２ 赤い岩
 */
public class KSpriteT12 extends KSpriteT00 implements KConstant {

	/** X移動量 */
	private		int				mx		= -1;

	/** 小惑星角度 */
	private		int				angle			= 0;
	private		int				velocity		= 0;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageT12_00 = null;
		BufferedImage imageT12_01 = null;
		BufferedImage imageT12_02 = null;
		BufferedImage imageT12_03 = null;

		imageT12_00 = KImage.getImage("image/imageT12_00.gif");
		imageT12_01 = KImage.getImage("image/imageT12_01.gif");
		imageT12_02 = KImage.getImage("image/imageT12_02.gif");
		imageT12_03 = KImage.getImage("image/imageT12_03.gif");

		KSpriteT12.setImage(KSpriteT12.class, new BufferedImage[]{
			imageT12_00,
			imageT12_01,
			imageT12_02,
			imageT12_03
		});

	} // end initImage

	/**
	 * コンストラクタ.
	 * @param panel KPanel
	 */
	public KSpriteT12(KPanel panel, String storyParam){

		super(panel);

		// X位置を設定
		intX = (int)(Math.random() * (WIDTH - getWidth()));

		intY = -getHeight();

		// X移動量が設定されている場合、
		if(storyParam != null){
			// X移動量を保存
			mx = Integer.parseInt(storyParam);
		}

		// 角度初期化
		angle = (int)(Math.random() * 360);
		velocity = (int)(Math.random() * 30) - 15;

	} // end KSpriteT12

	/**
	 * 実行.
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * <pre>
	 */
	public void run(){

		// 親クラスを実行する
		super.run();

		// 前進（斜め移動）
		intY = intY + 8;
		intX = intX + mx;
 
		// 回転
		angle = angle + velocity;

		// 画面の外に出た場合、
		if(intY > HEIGHT){
			// スプライトを消す
			super.removeSprite();
		}

	} // end run

	/**
	 * スプライト描画
	 * <pre>
	 * 表示の必要があれば実行される。
	 * </pre>
	 */
	public void paint(Graphics g){

		// Graphics2Dを取得
		Graphics2D g2 = (Graphics2D) g;

		// Transformを取得する
		AffineTransform af = new AffineTransform();

		// 回転を計算
		double radAsteroid = angle * Math.PI/180;
		// 表示位置計算
		double xAsteroid = ((double)intX + this.getWidth() / 2) * panel.getRatioWidth();
		double yAsteroid = ((double)intY + this.getHeight() / 2) * panel.getRatioHeight();

		// 回転を加え、表示位置を決定する
		af.setToRotation(radAsteroid, xAsteroid, yAsteroid);

		// Transformを設定する
		g2.setTransform(af);

		// 小惑星を描画する
		g2.drawImage(this.getImage(), (int)(intX * panel.getRatioWidth()), (int)(intY * panel.getRatioHeight()),
						(int)(this.getWidth() * panel.getRatioWidth()), (int)(this.getHeight() * panel.getRatioWidth()),
						super.getKPanel());

		// 回転と表示位置を戻す
		af.setToRotation(0d, 0d, 0d);

		// Transformを設定する
		g2.setTransform(af);

	} // end paint

	/**
	 * 爆発.
	 */
	public void bomb(){

		((KCtrlSKK)panel.getKCtrl()).addScore(50);

		super.bomb();

	} // end bomb

}

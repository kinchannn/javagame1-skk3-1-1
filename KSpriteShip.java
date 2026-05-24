import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * 自機
 */
public class KSpriteShip extends KSprite implements KConstant {

	/** 移動量 */
	private float amount = 0.0f;

	/** ビーム発射間隔 */
	private		int					intervalBeam		= 20;

	/** ビームスピード */
	private		int					speedBeam			= 12;

	/** ビーム時間 */
	private		int					timeBeam			= intervalBeam;

	/** 被弾時間 */
	private		int					timeHidan			= 0;

	/** 被弾立て直し時間 */
	private final int				HIDAN				= 200;

	/** Zキー押下フラグ */
	private		boolean				flgZ				= false;

	/** Aキー押下フラグ */
	private		boolean				flgA				= false;

	/** Beamオートフラグ */
	private		boolean				flgAutoBeam			= true;

	/** 爆発フラグ */
	private		boolean				flgBomb				= false;

	/** 爆発時間 */
	private		int					timeBomb			= -1;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageShip = null;
		BufferedImage imageB01 = null;
		BufferedImage imageB02 = null;

		imageShip = KImage.getImage("image/imageShip.gif");
		imageB01 = KImage.getImage("image/imageBomb1.gif");
		imageB02 = KImage.getImage("image/imageBomb2.gif");

		KSpriteShip.setImage(KSpriteShip.class, new BufferedImage[]{
			imageShip,
			imageB01,
			imageB02
		});

	} // end initImage

	/**
	 * コンストラクタ
	 */
	public KSpriteShip(KPanel panel){

		super(panel);

	} // end KSpriteShip

	/**
	 * 初期化
	 */
	public void init(){

		// 位置初期化
		this.setX(284);
		this.setY(480);

		// ビーム発射間隔
		intervalBeam		= 20;
		// ビームスピード
		speedBeam			= 12;
		// ビーム時間.
		timeBeam			= intervalBeam;
		// 被弾時間.
		timeHidan			= 0;

		// 爆発フラグ
		flgBomb = false;

		// イメージ初期化
		setImage(KSpriteShip.class, 0);

	} // end init

	/**
	 * 実行.
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * 継承先で定義をしてください。
	 * <pre>
	 */
	public void run(){

		// 撃墜された場合、
		if(flgBomb){

			timeBomb++;

			if(timeBomb == 10){
				setImage(KSpriteShip.class, 2);
			}else if(timeBomb == 30){
				setImage(KSpriteShip.class, 1);
			}

			// リターン
			return;

		} // end if 撃墜された場合

		//
		// 移動
		//

		// ステージクリア中でもゲームオーバー中でもない場合、
		if(((KCtrlSKK)panel.getKCtrl()).getPhase() != KCtrlSKK.PHASE_STAGE_CLEAR &&
				((KCtrlSKK)panel.getKCtrl()).getPhase() != KCtrlSKK.PHASE_END){

			if(panel.isKeyCodePressed(KeyEvent.VK_LEFT)){
				if(intX > 0){
					intX = intX - (int)(4.0 + amount);
				}
			}

			if(panel.isKeyCodePressed(KeyEvent.VK_RIGHT)){
				if(intX < (WIDTH - this.getWidth())){
					intX = intX + (int)(4.0 + amount);
				}
			}

			if(panel.isKeyCodePressed(KeyEvent.VK_UP)){
				if(intY > 0){
					intY = intY - (int)(4.0 + amount);
				}
			}

			if(panel.isKeyCodePressed(KeyEvent.VK_DOWN)){
				if(intY < (HEIGHT - this.getHeight())){
					intY = intY + (int)(4.0 + amount);
				}
			}

			//
			// ビーム
			//
			this.timeBeam++;

			// ビームオート かつ 時間が来たら、
			// もしくは、Ctrlキーを押していなかった時に押した時、
			if(this.flgAutoBeam && this.timeBeam >= this.intervalBeam ||
							panel.isKeyCodePressed(KeyEvent.VK_Z) && !flgZ){

				this.timeBeam = 0;

				KSpriteBeam1 spriteBeam1 = new KSpriteBeam1(panel, speedBeam);
				panel.addSprite(LAYOUT_TEKI, spriteBeam1);
				spriteBeam1.setX(this.getX());
				spriteBeam1.setY(this.getY());

				// ビーム音スタート
				((KCtrlSKK)panel.getKCtrl()).startWaveBeam();

			}

			// Aキーを押していなかった時に押した時、
			if(panel.isKeyCodePressed(KeyEvent.VK_A) && !flgA){
				// ビームオート制御
				this.flgAutoBeam = !this.flgAutoBeam;
			}

			// Zキー制御
			flgZ = panel.isKeyCodePressed(KeyEvent.VK_Z);

			// Aキー制御
			flgA = panel.isKeyCodePressed(KeyEvent.VK_A);

		} // end if ステージクリア中ではない場合、

		//
		// 判定
		//

		// スプライト一覧取得
		ArrayList<KSprite> spriteLst = panel.getSpriteLst(LAYOUT_TEKI);

		// スプライト一覧の件数を取得
		int countSpriteLst = spriteLst.size();

		// スプライト一覧の件数分、ループ
		for(int i = 0; i < countSpriteLst; i++){

			// スプライトを取得
			KSprite sprite = spriteLst.get(i);

			// nullの場合、
			if(sprite == null){
				// コンティニュー
				continue;
			}

			// XY取得
			int intXSprite = sprite.intX;
			int intYSprite = sprite.intY;

			// 大きさ取得
			int intWidthSprite = sprite.getWidth();
			int intHeightSprite = sprite.getHeight();

			// 当たり判定
			if(intX + 4 < (intXSprite + intWidthSprite) && intXSprite < (intX + this.getWidth() - 4) &&
							intY + 4 < (intYSprite + intHeightSprite) && intYSprite < (intY + this.getHeight() - 4) ){

			// 当たっていない場合、
			}else{
				// コンティニュー
				continue;
			}

			// 地上物の場合、
			if(sprite instanceof KSpriteG00){

				// 何もしない

			// 敵の場合、
			}else if(sprite instanceof KSpriteT00){

				// 被弾中の場合、
				if(timeHidan > 0){
					// コンティニュー
					continue;
				}

				// 敵にキャスト
				KSpriteT00 spriteT00 = (KSpriteT00)sprite;

				// 当たり判定しない場合、
				if(!spriteT00.isHanteiAtari()){
					// コンティニュー
					continue;
				}

				// 爆発している場合、
				if(spriteT00.isBomb()){
					// コンティニュー
					continue;
				}

				// 敵を爆発させる
				spriteT00.bomb();

				// 被弾処理
				hidan();

			// ビームの場合、
			}else if(sprite instanceof KSpriteT99 || sprite instanceof KSpriteT9A || sprite instanceof KSpriteT9B){

				// 被弾中の場合、
				if(timeHidan > 0){
					// コンティニュー
					continue;
				}

				// ビームを消去する
				sprite.removeSprite();

				// 被弾処理
				hidan();

			// Sの場合、
			}else if(sprite instanceof KSpriteS01){

				// スプライトを削除
				sprite.removeSprite();

				// 移動量が最大以外の場合、
				if(amount <= 2){

					// 移動量を増やす
					amount = amount + 0.5f;

				}

				// アイテム取得スタート
				((KCtrlSKK)panel.getKCtrl()).startWaveItemGet();

			// Mの場合、
			}else if(sprite instanceof KSpriteS02){

				// スプライトを削除
				sprite.removeSprite();

				// ビーム発射間隔が最大以外の場合、
				if(intervalBeam > 5){

					// ビーム発射間隔を短くする
					intervalBeam = intervalBeam - 3;

				}

				// アイテム取得スタート
				((KCtrlSKK)panel.getKCtrl()).startWaveItemGet();

			// Hの場合、
			}else if(sprite instanceof KSpriteS03){

				// スプライトを削除
				sprite.removeSprite();

				// ビームスピードが最大以外の場合、
				if(speedBeam < 20){

					// ビームスピードを早くする
					speedBeam = speedBeam + 4;

				}

				// アイテム取得スタート
				((KCtrlSKK)panel.getKCtrl()).startWaveItemGet();

			// 1の場合、
			}else if(sprite instanceof KSpriteS04){

				// スプライトを削除
				sprite.removeSprite();

				// 防御加算
				((KCtrlSKK)panel.getKCtrl()).addShield(1);

				// アイテム取得スタート
				((KCtrlSKK)panel.getKCtrl()).startWaveItemGet();

			}

		} // end for スプライト一覧の件数分、ループ

		// 被弾時間計算
		timeHidan = (timeHidan > 0)?--timeHidan: 0;

	} // end run

	/**
	 * 表示の必要があれば実行されるメソッド
	 * <pre>
	 * 被弾中は一時的に表示しません。
	 * </pre>
	 */
	public void paint(Graphics g){

		// 撃墜後の場合、
		if(timeBomb >= 40){
			// リターン
			// 自機を表示しない
			return;
		}

		// 被弾中の場合、
		if(timeHidan > 0){

			// 表示しない場合、
			if((timeHidan % 20) > 10){
				// リターン
				// 自機を表示しない
				return;
			}

		}

		super.paint(g);

	} // end paint

	/**
	 * 被弾処理
	 */
	private void hidan(){

		// 防御減算
		int shield = ((KCtrlSKK)panel.getKCtrl()).addShield(-1);

		// 防御が無くなった場合、
		if(shield == 0){

			// 撃墜
			flgBomb = true;

			//  爆発音スタート
			((KCtrlSKK)panel.getKCtrl()).startWaveBomb();

			setImage(KSpriteShip.class, 1);

			// リターン
			return;

		// 防御が残っている場合、
		}else{

			//  敵接触音スタート
			((KCtrlSKK)panel.getKCtrl()).startWaveCollision();

		} // end if

		// 移動量を減らす
		if(amount > 0.0f){
			amount = amount - 0.5f;
		}

		// ビーム発射間隔を長くする
		if(intervalBeam < 20){
			intervalBeam = intervalBeam + 3;
		}

		// ビームスピードを遅くする
		if(speedBeam > 12){
			speedBeam = speedBeam - 4;
		}

		// 被弾時間
		timeHidan = HIDAN;

	} // end hidan

}

import java.awt.image.*;
import java.io.*;
import java.util.*;

public class KSpriteBeam1 extends KSprite implements KConstant {

	private		int		mY		= 12;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageBeam1 = null;

		imageBeam1 = KImage.getImage("image/imageBeam1.gif");

		KSpriteBeam1.setImage(KSpriteBeam1.class, imageBeam1);

	} // end initImage

	/**
	 * コンストラクタ
	 */
	public KSpriteBeam1(KPanel panel, int mY){

		super(panel);

		this.mY = mY;

	}

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * 継承先で定義をしてください。
	 * <pre>
	 */
	public void run(){

		intY = intY - mY;

		if(intY < -32){
			super.removeSprite();
		}

		//
		// 判定
		//

		// 地面の層と敵の層のループ
		for(int i = 0; i < 2; i++){

			// スプライト層決定
			int layout = (i == 0)?LAYOUT_TEKI: LAYOUT_JIMEN_1;

			// スプライト一覧取得
			ArrayList<KSprite> spriteLst = panel.getSpriteLst(layout);

			// スプライト一覧の件数を取得
			int countSpriteLst = spriteLst.size();

			// スプライト一覧の件数分、ループ
			for(int j = 0; j < countSpriteLst; j++){

				// スプライトを取得
				KSprite sprite = spriteLst.get(j);

				// nullの場合、
				if(sprite == null){
					// コンティニュー
					continue;
				}

				// 敵ではない場合、
				if(!(sprite instanceof KSpriteT00)){
					// コンティニュー
					continue;
				}

				// 敵にキャスト
				KSpriteT00 spriteT00 = (KSpriteT00)sprite;

				// 爆発している場合、
				if(spriteT00.isBomb()){
					// コンティニュー
					continue;
				}

				// 当たり判定しない場合、
				if(!spriteT00.isHanteiAtari()){
					// コンティニュー
					continue;
				}

				// XY取得
				int intXT00 = spriteT00.intX;
				int intYT00 = spriteT00.intY;

				// 敵が表示しきっていない場合、
				if(intYT00 < 0){
					// コンティニュー
					continue;
				}

				// 大きさ取得
				int intWidthT00 = spriteT00.getWidth();
				int intHeightT00 = spriteT00.getHeight();

				// 当たり判定
				if(intX < (intXT00 + intWidthT00) && intXT00 < (intX + this.getWidth()) &&
								intY < (intYT00 + intHeightT00) && intYT00 < (intY + this.getHeight()) ){
					// 爆発
					spriteT00.bomb();
					// スプライト削除
					super.removeSprite();

				}

			} // end for スプライト一覧の件数分、ループ

		} // end for 地面の層と敵の層のループ

	} // end run

}

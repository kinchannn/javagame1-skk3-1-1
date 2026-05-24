import java.util.*;

/**
 * 敵９
 */
public class KSpriteGroupT09 extends KSpriteGroup implements KConstant {

	/** X座標 */
	private		int			intX		= 0;

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 */
	public KSpriteGroupT09(KPanel panel){

		super(panel);

		// スプライト一覧取得
		ArrayList<KSprite> spriteLst = panel.getSpriteLst(LAYOUT_JIBUN);

		// 自機を取得
		KSprite spriteShip = spriteLst.get(0);

		// 位置を設定
		intX = ((spriteShip.getX() + spriteShip.getWidth() / 2) > (WIDTH / 2))?0: WIDTH - 48;

	}

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * <pre>
	 */
	public void run(){

		// 一定時間経過の場合、
		if((time % 10) == 0){
			// スプライトを生成
			KSpriteT09 kSpriteT09 = new KSpriteT09(super.getKPanel(), intX);
			// スプライトを追加
			super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT09);
		}

		// 20回出たら、
		if(time == 200){
			// スプライトグループを消す
			super.getKPanel().removeSpriteGroup(this);
		}

	} // end run

}

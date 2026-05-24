/**
 * 敵４
 */
public class KSpriteGroupT04 extends KSpriteGroup implements KConstant {

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 */
	public KSpriteGroupT04(KPanel panel){
		super(panel);
	}

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * <pre>
	 */
	public void run(){

		// 一定時間経過の場合、
		if((time % 40) == 0){
			// スプライトを生成
			KSpriteT04 kSpriteT04 = new KSpriteT04(super.getKPanel());
			// スプライトを追加
			super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT04);
		}

		// 10回出たら、
		if(time == 360){
			super.getKPanel().removeSpriteGroup(this);
		}

	} // end run

}

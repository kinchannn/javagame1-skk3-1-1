/**
 * 敵８
 */
public class KSpriteGroupT08 extends KSpriteGroup implements KConstant {

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 */
	public KSpriteGroupT08(KPanel panel){
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
		if((time % 10) == 0){
			// スプライトを生成
			KSpriteT08 kSpriteT08 = new KSpriteT08(super.getKPanel());
			// スプライトを追加
			super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT08);
		}

		// 30回出たら、
		if(time >= 290){
			// スプライトグループを消す
			super.getKPanel().removeSpriteGroup(this);
		}

	} // end run

}

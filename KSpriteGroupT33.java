/**
 * 敵３３
 */
public class KSpriteGroupT33 extends KSpriteGroup implements KConstant {

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 * @param storyParam ビーム発射間隔
	 */
	public KSpriteGroupT33(KPanel panel){
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
			KSpriteT33 kSpriteT33 = new KSpriteT33(super.getKPanel());
			// スプライトを追加
			super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT33);
		}

		// 30回出たら、
		if(time == 300){
			// スプライトグループを消す
			super.getKPanel().removeSpriteGroup(this);
		}

	} // end run

}

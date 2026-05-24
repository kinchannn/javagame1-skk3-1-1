/**
 * 敵７
 */
public class KSpriteGroupT07 extends KSpriteGroup implements KConstant {

	/** ビーム発射間隔 */
	private		String		storyParam	= null;

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 * @param storyParam ビーム発射間隔
	 */
	public KSpriteGroupT07(KPanel panel, String storyParam){
		super(panel);
		this.storyParam = storyParam;
	}

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * <pre>
	 */
	public void run(){

		// 一定時間経過の場合、
		if((time % 30) == 0){
			// スプライトを生成
			KSpriteT07 kSpriteT07 = new KSpriteT07(super.getKPanel(), storyParam);
			// スプライトを追加
			super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT07);
		}

		// 10回出たら、
		if(time == 300){
			// スプライトグループを消す
			super.getKPanel().removeSpriteGroup(this);
		}

	} // end run

}

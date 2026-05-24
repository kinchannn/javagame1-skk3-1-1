/**
 * 地面３７
 */
public class KSpriteGroupJ37 extends KSpriteGroupJ00 implements KConstant {

	private	static final int[][]	JSS			= new int[][]{
		{ 0, J01, 1, J01, 2, J01, 3, J01, 4, J01, 5, J01, 6, J01, 7, J01, 8, J01, 9, J01, 10, J01, 11, J01, 12, J01, 13, J01, 14, J01, 15, J01, 16, J01, 17, J01, 18, J01, 0, G31, 1, G31, 2, G31, 3, G31, 4, G31, 5, G31, 6, G31, 7, G31, 8, G31, 9, G31, 10, G31, 11, G31, 12, G31, 13, G31, 14, G31, 15, G31, 16, G31, 17, G31, 18, G31},
		{ 0, J08, 1, J01, 2, J01, 3, J08, 4, J01, 5, J01, 6, J08, 7, J01, 8, J01, 9, J08, 10, J01, 11, J01, 12, J08, 13, J01, 14, J01, 15, J08, 16, J01, 17, J01, 18, J08, 0, G31, 1, G31, 2, G31, 3, G31, 4, G31, 5, G31, 6, G31, 7, G31, 8, G31, 9, G31, 10, G31, 11, G31, 12, G31, 13, G31, 14, G31, 15, G31, 16, G31, 17, G31, 18, G31},
	};

	private		int				pos				= JSS.length;

	/**
	 * コンストラクタ
	 */
	public KSpriteGroupJ37(KPanel panel, String storyParam){

		super(panel);

		if(storyParam != null){

			int intX = Integer.parseInt(storyParam);

			super.setX(intX);

		}

	}

	/**
	 * 実行メソッド
	 */
	public void run(){

		// 一定時間経過の場合、
		if((time % 16) == 0){

			// ポジションを変更
			pos--;

			// 地面データを取得
			int[] js = JSS[pos];

			// スプライト配置
			super.haitiSprite(js);

		} // end if 一定時間経過の場合

		// 全て配置したら、
		if(pos <= 0){
			// スプライトグループを削除
			super.getKPanel().removeSpriteGroup(this);
		}

	} // end run

}

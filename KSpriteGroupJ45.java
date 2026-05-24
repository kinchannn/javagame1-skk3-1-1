import java.util.*;

/**
 * 地面４５
 */
public class KSpriteGroupJ45 extends KSpriteGroupJ00 implements KConstant {

	private	static final int[][]	JSS			= new int[][]{
		{ 0, N00, 1,N00, 2,N00, 3,N00,4,N00, 5, J01, 6, J01, 7, J01, 8, J01, 9, J01, 10, J01, 11, J01, 12, J01, 13, J01, 14, J01, 15, J01, 16, J01, 17, J01, 18, J01, 0, J31, 1,J32, 2,J32, 3,J32,4,J33, 5, G61, 7, G61, 9, G61, 11, G61, 13, G61, 15, G61, 17, G31, 18, G31},
		{ 0, N00, 1,J01, 2,J01, 3,J01,4,N00, 5, J01, 6, J01, 7, J01, 8, J01, 9, J01, 10, J01, 11, J01, 12, J01, 13, J01, 14, J01, 15, J01, 16, J01, 17, J01, 18, J01, 0, J34, 1,G32_2, 2,G32_3, 3,G32_1,4,J34, 17, G31, 18, G31},
		{ 0, N00, 1,J01, 2,J01, 3,J01,4,N00, 5, N00, 6, N00, 7, N00, 8, N00, 9, N00, 10, N00, 11, N00, 12, N00, 13, N00, 14, N00, 15, N00, 16, N00, 17, N00, 18, J01, 0, J34, 1,G32_2, 2,G32_3, 3,G32_1,4,J36, 5, J32, 6, J32, 7, J32, 8, J32, 9, J32, 10, J32, 11, J32, 12, J32, 13, J32, 14, J32, 15, J32, 16, J32, 17, J33, 18, G31},
		{ 0, N00, 1,J01, 2,J01, 3,J01,4,J01, 5, J01, 6, J01, 7, J01, 8, J01, 9, J01, 10, J01, 11, J01, 12, J01, 13, J01, 14, J01, 15, J01, 16, J01, 17, N00, 18, J01, 0, J34, 1,G41, 3,G41, 5, G72, 6, J41_0, 9, G72, 13, G72, 17, J34, 18, G31},
		{ 0, N00, 1,J01, 2,J01, 3,J01,4,J01, 5, J01, 6, J01, 7, J01, 8, J01, 9, J01, 10, J01, 11, J01, 12, J01, 13, J01, 14, J01, 15, J01, 16, J01, 17, N00, 18, J01, 0, J34, 1,G41, 3,G41, 17, J34, 18, G31},
		{ 0, N00, 1,J01, 2,J01, 3,J01,4,J01, 5, J01, 6, J01, 7, J01, 8, J01, 9, J01, 10, J01, 11, J01, 12, J01, 13, J01, 14, J01, 15, J01, 16, J01, 17, N00, 18, J01, 0, J34, 1,G41, 3,G41, 17, J34, 18, G31},
		{ 0, N00, 1,J01, 2,J01, 3,J01,4,J01, 5, J01, 6, J01, 7, J01, 8, J01, 9, J01, 10, J01, 11, J01, 12, J01, 13, J01, 14, J01, 15, J01, 16, J01, 17, N00, 18, J01, 0, J34, 1,G31, 2,G31, 3,G31,4,G31, 17, J34, 18, G31},
		{ 0, N00, 1,J01, 2,J01, 3,J01,4,J01, 5, J01, 6, J01, 7, J01, 8, J01, 9, J01, 10, J01, 11, J01, 12, J01, 13, J01, 14, J01, 15, J01, 16, J01, 17, N00, 18, J01, 0, J34, 1,G62, 3,G62, 5, G72, 6, J41_1, 9, G72, 13, G72, 17, J34, 18, G31},
		{ 0, N00, 1,J01, 2,J01, 3,J01,4,J01, 5, J01, 6, J01, 7, J01, 8, J01, 9, J01, 10, J01, 11, J01, 12, J01, 13, J01, 14, J01, 15, J01, 16, J01, 17, N00, 18, J01, 0, J34, 16, G31, 17, J34, 18, G31},
		{ 0, N00, 1,J01, 2,J01, 3,J01,4,J01, 5, J01, 6, J01, 7, J01, 8, J01, 9, J01, 10, J01, 11, J01, 12, J01, 13, J01, 14, J01, 15, J01, 16, J01, 17, N00, 18, J01, 0, J34, 1,G62, 3,G62, 16, G31, 17, J34, 18, G31},
		{ 0, N00, 1,J01, 2,J01, 3,J01,4,J01, 5, J01, 6, J01, 7, J01, 8, J01, 9, J01, 10, J01, 11, J01, 12, J01, 13, J01, 14, J01, 15, J01, 16, J01, 17, N00, 18, J01, 0, J34, 16, G31, 17, J34, 18, G31},
		{ 0, N00, 1,J01, 2,J01, 3,J01,4,J01, 5, N00, 6, N00, 7, N00, 8, N00, 9, J01, 10, J01, 11, N00, 12, N00, 13, N00, 14, N00, 15, N00, 16, J01, 17, N00, 18, J01, 0, J34, 1,G33, 2,G34, 3,G35,4,G33, 5, J31, 6, J32, 7, J32, 8, J33, 9, G62, 11, J31, 12, J32, 13, J32, 14, J32, 15, J33, 16, G31, 17, J34, 18, G31},
		{ 0, N00, 1,J01, 2,J01, 3,J01,4,J01, 5, N00, 6, J01, 7, J01, 8, N00, 9, J01, 10, J01, 11, N00, 12, J01, 13, J01, 14, J01, 15, N00, 16, J01, 17, N00, 18, J01, 0, J34, 1,G41, 3,G41, 5, J34, 6, G41, 8, J34, 11, J34, 12, G31, 13, G41, 15, J34, 16, G31, 17, J34, 18, G31},
		{ 0, N00, 1,N00, 2,N00, 3,N00,4,J01, 5, N00, 6, J01, 7, J01, 8, N00, 9, J01, 10, J01, 11, N00, 12, J01, 13, J01, 14, J01, 15, N00, 16, J01, 17, N00, 18, J01, 0, J36, 1,J32, 2,J32, 3,J33,4,G31, 5, J34, 6, G41, 8, J34, 9, G62, 11, J34, 12, G31, 13, G41, 15, J34, 16, G31, 17, J34, 18, G31},
		{ 0, J01, 1,J01, 2,J01, 3,N00,4,J01, 5, N00, 6, J01, 7, J01, 8, N00, 9, J01, 10, J01, 11, N00, 12, J01, 13, J01, 14, J01, 15, N00, 16, J01, 17, N00, 18, J01, 0, G62, 2,G31, 3,J34,4,G31, 5, J34, 6, G41, 8, J34, 11, J34, 12, G31, 13, G41, 15, J34, 16, G31, 17, J34, 18, G31},
		{ 0, J01, 1,J01, 2,J01, 3,N00,4,J01, 5, N00, 6, J01, 7, J01, 8, N00, 9, J01, 10, J01, 11, N00, 12, J01, 13, J01, 14, J01, 15, N00, 16, J01, 17, N00, 18, J01, 2, G31, 3,J34,4,G31, 5, J34, 6, G41, 8, J34, 9, G62, 11, J34, 12, G31, 13, G41, 15, J34, 16, G31, 17, J34, 18, G31},
		{ 0, J01, 1,J01, 2,J01, 3,N00,4,J01, 5, N00, 6, J01, 7, J01, 8, N00, 9, J01, 10, J01, 11, N00, 12, J01, 13, J01, 14, J01, 15, N00, 16, J01, 17, N00, 18, J01, 0, G63, 2,G31, 3,J34,4,G31, 5, J34, 6, G41, 8, J34, 11, J34, 12, G31, 13, G41, 15, J34, 16, G31, 17, J34, 18, G31},
		{ 0, J01, 1,J01, 2,J01, 3,N00,4,N00, 5, N00, 6, J01, 7, J01, 8, N00, 9, N00, 10, N00, 11, N00, 12, J01, 13, J01, 14, J01, 15, N00, 16, N00, 17, N00, 18, J01, 2, G31, 3,J36,4,J32, 5, J35, 6, G41, 8, J36, 9, J32, 10, J32, 11, J35, 12, G31, 13, G41, 15, J36, 16, J32, 17, J35, 18, G31},
	};

	// 表示した位置
	private		int								pos					= JSS.length;

	// ストップしたフラグ
	private		boolean							flgStop				= false;

	// スプライトグループ一覧
	private		ArrayList<KSpriteGroupT43>		spriteGroupT43Lst	= new ArrayList<KSpriteGroupT43>();

	/**
	 * コンストラクタ
	 */
	public KSpriteGroupJ45(KPanel panel, String storyParam){

		super(panel);

		if(storyParam != null){

			int intX = Integer.parseInt(storyParam);

			super.setX(intX);

		}

		// ループ
		for(int i = 0; i < 10; i++){

			// スプライトを生成
			KSpriteG38 kSprite = new KSpriteG38(super.getKPanel(), i, this);

			// スプライトを追加
			super.getKPanel().addSprite(LAYOUT_JIMEN_1, kSprite);

			// スプライトグループを設定
			kSprite.setSpriteGroup(this);

			// スプライト追加（残機＋１）
			addSprite();

		} // end for ループ

		// ステージ音ストップ
		((KCtrlSKK)super.getKPanel().getKCtrl()).stopMidiStage();

		// ボス警告スタート
		((KCtrlSKK)super.getKPanel().getKCtrl()).startBossWarning();

	} // end KSpriteGroupJ45

	/**
	 * 実行メソッド
	 */
	public void run(){

		// 一定時間経過の場合、
		if((time % 16) == 0){

			// ポジションを変更
			pos--;

			// 未配置データがある場合、
			if(pos >= 0){

				// 地面データを取得
				int[] js = JSS[pos];

				// スプライト配置
				super.haitiSprite(js);

			}

		} // end if 一定時間経過の場合

		// 全て配置した かつ ストップしていない場合、
		if(pos == -4 && !flgStop){

			// ストップしたフラグ
			flgStop = true;

			// 移動ストップ
			super.stopMove();

			// ボス音スタート
			((KCtrlSKK)super.getKPanel().getKCtrl()).startMidiBoss();

		}

		// 一定時間経過の場合、
		if(time < 4000 && (time % 1200) == 300){

			// スプライトを生成
			KSpriteGroupT43 spriteGroupT43 = new KSpriteGroupT43(super.getKPanel());

			// スプライトを追加
			super.getKPanel().addSpriteGroup(spriteGroupT43);

			// スプライトグループ一覧に追加
			spriteGroupT43Lst.add(spriteGroupT43);

		}

	} // end run

	/**
	 * スプライト削除
	 * <pre>
	 * スプライトグループで管理しているスプライトを削除します。
	 * <pre>
	 * @return true − 削除後も他のスプライトは存在している ／ false − 存在していない
	 */
	public boolean removeSprite(){

		// スーパークラスを呼び出し。
		// スプライトが存在しているか返却してもらう
		boolean flgExist = super.removeSprite();

		// スプライトが存在していない場合、
		if(!flgExist){

			// ボス音ストップ
			((KCtrlSKK)super.getKPanel().getKCtrl()).stopMidiBoss();

			// スプライトグループ一覧の件数を取得
			int countSpriteGroupT43Lst = spriteGroupT43Lst.size();

			// スプライトグループ一覧の件数分、ループ
			for(int i = 0; i < countSpriteGroupT43Lst; i++){

				// スプライトグループを取得
				KSpriteGroupT43 spriteGroupT43 = spriteGroupT43Lst.get(i);

				// 全ての残っている敵機を破壊する
				spriteGroupT43.allBomb();

			} // end for スプライトグループ一覧の件数分、ループ

		} // end if スプライトが存在していない場合

		// リターン
		return flgExist;

	} // end removeSprite

}

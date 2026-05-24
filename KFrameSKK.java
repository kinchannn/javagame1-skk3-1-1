import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * フレームクラス
 */
public class KFrameSKK extends JFrame implements KConstant {

	/** コントロールクラス */
	KCtrlSKK	kCtrl		= null;

	/** パネルクラス */
	KPanel		kPanel		= null;

	/**
	 * 実行
	 * <pre>
	 * 当メソッドから、はじまります。
	 * </pre>
	 * @param args 引数
	 */
	public static void main(String[] args){

		EventQueue.invokeLater(new Runnable(){

			public void run(){

				// フレームを生成
				KFrameSKK test = new KFrameSKK();

			}

		});

	} // end main

	/**
	 * コンストラクタ
	 * <pre>
	 * コンストラクタ。
	 * フレーム系の初期化を行います。
	 * </pre>
	 */
	public KFrameSKK(){

		super();

		super.setSize(KConstant.WIDTH, KConstant.HEIGHT);

		// レイアウト設定
		super.setLayout(new BorderLayout());

		// ウインドウリスナー追加
		KFrameWindowAdapter kfwa = new KFrameWindowAdapter();

		super.addWindowListener(kfwa);
		super.addWindowFocusListener(kfwa);

		// イメージクラスに自分を渡す
		KImage.setContainer(this);

		// コントロールクラス生成
		kCtrl = new KCtrlSKK(this);

		// パネル取得
		kPanel = kCtrl.getKPanel();

		// 最適サイズを設定
		kPanel.setPreferredSize(new Dimension(KConstant.WIDTH, KConstant.HEIGHT));

		// タイトル設定
		super.setTitle("SKK");

		// パネルを設定
		super.setContentPane(kPanel);

		// フレームサイズの設定
		super.pack();

		// 表示する
		super.setVisible(true);

		// フォーカスを取得
		super.requestFocus();
		// パネルにフォーカスを当てる
		kPanel.requestFocus();

		// コントロールクラスを開始
		kCtrl.start();

	} // end KFrameSKK

	/**
	 * ウインドウアダプタクラス
	 */
	private class KFrameWindowAdapter extends WindowAdapter {

		/**
		 * ウインドウが閉じる時に呼ばれるイベントです.
		 */
		@Override
		public void windowClosing(WindowEvent we){
			System.exit(0);
		}

		/**
		 * フォーカスされた時に呼ばれるイベントです.
		 */
		@Override
		public void windowGainedFocus(WindowEvent we){
			kPanel.requestFocus();
		}

	}

}

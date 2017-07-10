package org.inchain.network;

import java.net.InetSocketAddress;

import org.inchain.Configure;
import org.inchain.crypto.Sha256Hash;
import org.inchain.message.DefaultMessageSerializer;
import org.inchain.message.MessageSerializer;
import org.inchain.store.BlockStore;
import org.inchain.utils.Hex;
import org.inchain.utils.Utils;

/**
 * 测试网络
 * @author ln
 *
 */
public class TestNetworkParams extends NetworkParams {

	public TestNetworkParams() {
		seedManager = new RemoteSeedManager();

		//seedManager.addDnsSeed("test1.seed.inchain.org");
		//seedManager.addDnsSeed("test2.seed.inchain.org");

//    	seedManager.add(new Seed(new InetSocketAddress("47.93.16.125", Configure.DEFAULT_PORT)));
//    	seedManager.add(new Seed(new InetSocketAddress("119.23.249.26", Configure.DEFAULT_PORT)));
//   	seedManager.add(new Seed(new InetSocketAddress("119.23.253.3", Configure.DEFAULT_PORT)));
//    	seedManager.add(new Seed(new InetSocketAddress("119.23.254.99", Configure.DEFAULT_PORT)));
		seedManager.add(new Seed(new InetSocketAddress("192.168.1.167", Configure.DEFAULT_PORT)));
    	seedManager.add(new Seed(new InetSocketAddress("192.168.1.183", Configure.DEFAULT_PORT)));
		init();
	}
    

	public TestNetworkParams(SeedManager seedManager) {
    	this.seedManager = seedManager;
    	init();
	}
    
	private void init() {
		
		id = ID_TESTNET;
		
		packetMagic = 629266569l;
		
		this.acceptableAddressCodes = new int[] {getSystemAccountVersion(), getCertAccountVersion()};
	}
	
	/**
	 * 测试网络的创世块
	 */
	@Override
	public BlockStore getGengsisBlock() {
		BlockStore gengsisBlock = new BlockStore(this, Hex.decode("0000000000000000000000000000000000000000000000000000000000000000000000007f623f71d05834105ef7f56034a320c5d3b04ded8b78e28cbe49907452ab3b582b1463590000000000002b146359832102883a9625a871e79c070e316edafc97eac2f6c97b218d0e55726f25be2a963e9276a9144237cccf6ff9a7674a8fc47c60278fdd23e9f30988473045022100f0c7c02ecd74da738d8913d6e44308bf7eb46ec1200ea702a7d7fad47606369b022072d115130ef44977dfe75a5a27f14cb61da5954216febcac0fcdd7d6b674cefbac160101000000010012117468697320612067656e6773697320747800000000010080faca73f91f0000000000000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688ac4aca062b5d01000000000000000000000002010000000101206aa38af20ba473eb28f06f3226f7aed08c2c390733f8406d98aa659b58879b000000006a473044022057b268fcdb35a86c78acec3a26c37854310a9ca0f6aa0577207aa900ba95acf002204b0afd47715d2a6a39bcc1dde8a2ee3de4546fad816b95f58300aaaa6741dd7601210276c52ff14acd4c4d3e08f9596e0127a15e98207b3d0024426364825cd724c86dffffffff020080c6a47e8d03000078c2486c0100001976a9144237cccf6ff9a7674a8fc47c60278fdd23e9f30988ac00003426f56b1c0000000000000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688ac7fca062b5d01000000000000000000000006010000008eca062b5d010000832102883a9625a871e79c070e316edafc97eac2f6c97b218d0e55726f25be2a963e9276a9144237cccf6ff9a7674a8fc47c60278fdd23e9f30988473045022100c4406cd534b2076b53fb27cc80a45d1e67014875ac6e04864cfd050fc9313d3102203543c590351a4deaed9bfc50dff31687c4695fae49d2a81c8a8f3b456b6f91a3ac4237cccf6ff9a7674a8fc47c60278fdd23e9f3097f9698000000000000000000000000000000000000000000000000000000000000000000000000000002010000000101cb2ca971ff5753cc28106735fb8b9e71389b52984b3d1fc54ad9072bc13e9a0c010000006b483045022100e25cb882078b5dce8ac21116787864bc630c5224856e39063ab3c3cd33e6c8c6022063a99e6569c964c31c73cc3046a547dd5aef979c324488ae9cbff347028bc6a901210276c52ff14acd4c4d3e08f9596e0127a15e98207b3d0024426364825cd724c86dffffffff0200407a10f35a000000000000000000001976a9144237cccf6ff9a7674a8fc47c60278fdd23e9f30988ac00c0b91502111c0000000000000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688ac8eca062b5d010000000000000000000000030100000000008eca062b5d010000000000000000000000822102883a9625a871e79c070e316edafc97eac2f6c97b218d0e55726f25be2a963e9276a9144237cccf6ff9a7674a8fc47c60278fdd23e9f30988463044022025795acbc1e88d0f3a4f37df791c84e2e8d005838ca34febe6712418456cf762022069606e8fa2c459167486f3419ed1fe9bcf003e6e01b709f51816eb3cb4000f29ac0a5f072b4237cccf6ff9a7674a8fc47c60278fdd23e9f30906010000009eca062b5d010000832103a7db4a854e3f2ae3a30aa759bfd39045f6a80c967b3fd81036acebc54b557ece76a9142c1179b1e05fb8652644f6c61a033d284310091288473045022100af6474669a21f6b74e3f8951b538596e89bea40b7a1bb22eabc3aa76dbe3356e022048eb71a1b211b0649cd9d7be0ae1a201ab5509a91c2abc2a987333451d2696e3ac2c1179b1e05fb8652644f6c61a033d28431009127f9698000000000000000000000000000000000000000000000000000000000000000000000000000002010000000101f2ca9512180aa8e8a26d6ac2f261465af2074e29429adf1331ecaf97bef5aa3a010000006b483045022100986812657a4ea4f2b880f3e9b0eda5d2d14c6d260416c730ef37a607ce8bfdcb02205e524b0cd0f6bfa7c4e804fb386d74ae671f1220098e473efa014d611e9cf30f01210276c52ff14acd4c4d3e08f9596e0127a15e98207b3d0024426364825cd724c86dffffffff0200407a10f35a000000000000000000001976a9142c1179b1e05fb8652644f6c61a033d284310091288ac00803f050fb61b0000000000000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688ac9eca062b5d010000000000000000000000030100000000009eca062b5d010000000000000000000000822103a7db4a854e3f2ae3a30aa759bfd39045f6a80c967b3fd81036acebc54b557ece76a9142c1179b1e05fb8652644f6c61a033d284310091288463044022041bf5b0e15ff87ad164db1bcb792995b517dffc82c324d2bd8b07b1d79683d2a022008fc77989f3ebed5bae45a199a6562849afc9a2a3d7b06e70169f86326b36ec3ac1a5f072b2c1179b1e05fb8652644f6c61a033d284310091206010000009eca062b5d0100008221033e371b2f3d42dd525833bcce12cb0d404fb73898bdea3e6794bd8ec552c9ba9c76a914b3fcd687a5c2b2617de0d504cfa7d12db93bb00c8846304402204e615deb1a608de0461ed4e288f133da6ce0cc14cd60a2a735838f519335304c02204384fffcf8936edfe390b063b23e2add0e77dcd9df2b3307d50e0afdd9f98894acb3fcd687a5c2b2617de0d504cfa7d12db93bb00c7f969800000000000000000000000000000000000000000000000000000000000000000000000000000201000000010174aec8eea074570d418130123f17da9d9aa36894e88cc30dda20d268dc62ce04010000006a4730440220430b3d517d627f31f1056343a90968c34dce3f38c4ab579c11854180d8af01170220295d9cb3c0c38de9030804fd8468e80ab2bff5a9cad5d8597872d531e131bc7101210276c52ff14acd4c4d3e08f9596e0127a15e98207b3d0024426364825cd724c86dffffffff0200407a10f35a000000000000000000001976a914b3fcd687a5c2b2617de0d504cfa7d12db93bb00c88ac0040c5f41b5b1b0000000000000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688ac9eca062b5d010000000000000000000000030100000000009eca062b5d0100000000000000000000008221033e371b2f3d42dd525833bcce12cb0d404fb73898bdea3e6794bd8ec552c9ba9c76a914b3fcd687a5c2b2617de0d504cfa7d12db93bb00c88463044022056b6e4e9e445814ad6ca5fd1e7b983922f32328803885dc74ffd17a786ff3cbe022022a8677a8fac71c0a25ee74bcf45c765e466f56ab049215ba8f8ee9613aa4e26ac1a5f072bb3fcd687a5c2b2617de0d504cfa7d12db93bb00c06010000009eca062b5d010000822103bf7759e9b81f8ff1b99732b3ee36aea0abff68c818b8839c318ad350e9642cb076a914c3bfdb8a67f35b6e4ea1ee3ae7b91eff58ec81a88846304402204c5f9f3fa4fd9715ed0ab58efbee8ba5b4fa1b18ef289cef1b0560131c4abaf602203b468f7e8f53e2043c2e4620757632ac868761d80b62b74b9605093d904ca7a1acc3bfdb8a67f35b6e4ea1ee3ae7b91eff58ec81a87f9698000000000000000000000000000000000000000000000000000000000000000000000000000002010000000101d885c8c9432f315d292ee9e08332e84ade3b6d8c7aa44b687b37f0bd92039575010000006b48304502210081c0afd5855e95cb427df5b87f400d994ba939aa44330cd862ab30f4a061ff900220224c13396a3068b0a91e1caca77297f7c73d629b79251a75253da7cd25e75ee001210276c52ff14acd4c4d3e08f9596e0127a15e98207b3d0024426364825cd724c86dffffffff0200407a10f35a000000000000000000001976a914c3bfdb8a67f35b6e4ea1ee3ae7b91eff58ec81a888ac00004be428001b0000000000000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688ac9eca062b5d0100000000000000000000000601000000aeca062b5d01000083210200d482122f8537ad2fa1af1914e088d6b308824a8ef4dc8b68fa0e0a88c484e376a9145f1a078b610d92a3110b2c1a7f880b0d2442e53088473045022100dda159baaff574ed37f4c214db92f97c0f3fbecd1f5a5b57457d310e17311eae02200a055ac1cfd379da0280eea9f5cf6afdee4016ebda9044f514ea1709d9c440abac5f1a078b610d92a3110b2c1a7f880b0d2442e5307f9698000000000000000000000000000000000000000000000000000000000000000000000000000002010000000101e82f9a62dca00140f8b9c32924c6615eeecb7927be58e2ee59ffb03cf2f0573d010000006a4730440220597defe8c885b131a53f80c1f7a74bc8f6c5600fb02ab865e6d3d40a59087a780220763e883d0dfa6ee54d8ed1ece457a5d15d09cc86d57be4ae49a83b635c8808bf01210276c52ff14acd4c4d3e08f9596e0127a15e98207b3d0024426364825cd724c86dffffffff0200407a10f35a000000000000000000001976a9145f1a078b610d92a3110b2c1a7f880b0d2442e53088ac00c0d0d335a51a0000000000000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688acafca062b5d0100000000000000000000000601000000b1ca062b5d010000832103e8769d1901a4ef006054405c16716d6648fffe628385db5586c7fa18c3df5da876a914df639c6066a817a6be28b532839f8e1e85594cd488473045022100d60b23d89686388528f98ff000c920df61269c124622d9a63ddf3edcb0312b2e02202f9d0a1e073c7142d59b523046dbc37353c11f5fdbb169b37b524ed22f5f00edacdf639c6066a817a6be28b532839f8e1e85594cd47f96980000000000000000000000000000000000000000000000000000000000000000000000000000020100000001014619d04f3ca9103975a9386f866c0dff6df992b0d04b57a94ee233bf1196d020010000006a47304402207fa1e0018f4df75543cc839afe2c6eac993206025877b98927e9fd10d1bb2e7902205aaafa94b9c58d15a0f1c31f99fdf9a53d6859f500737b59d3e2648ce274d05f01210276c52ff14acd4c4d3e08f9596e0127a15e98207b3d0024426364825cd724c86dffffffff0200407a10f35a000000000000000000001976a914df639c6066a817a6be28b532839f8e1e85594cd488ac008056c3424a1a0000000000000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688acb1ca062b5d0100000000000000000000000601000000b3ca062b5d010000822103368f8061e02694e37da199c07c3e2f2506cdd748efee493f0d1c52ae7494428f76a914e3453a80144f6ac24baf01f20455c6167b9854858846304402203dbbc48e731ccc496f65be608f4e1e01a39f276437eb8eb0086d719add40e67602206607d51449e46a5b3a269e581d08affdfa6dfcd67ec2334c3fff981f4886d0d8ace3453a80144f6ac24baf01f20455c6167b9854857f9698000000000000000000000000000000000000000000000000000000000000000000000000000002010000000101d0c16af26001d68295c47ea20689cec3587de82cf022bed75e93d8b7964fa3be010000006a47304402202a04bed12c9a4cb21c12c62eb2531226bd84f836cffd86d9b65a5cceffac67b40220462ea896954be71ce4404f65d3832e24953e22b8649f27b65a59f44cd05462bf01210276c52ff14acd4c4d3e08f9596e0127a15e98207b3d0024426364825cd724c86dffffffff0200407a10f35a000000000000000000001976a914e3453a80144f6ac24baf01f20455c6167b98548588ac0040dcb24fef190000000000000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688acb3ca062b5d0100000000000000000000000b01000000c3ca0a125d010000ffec3f337d87f2c50995bc6572bdfa78b5ac7750ffec3f337d87f2c50995bc6572bdfa78b5ac775001fd070e2b046e616d6506e5908de7a7b01ee9878de5ba86e58db0e993bee7a791e68a80e69c89e99990e585ace58fb822076164647265737306e59cb0e59d8012e9878de5ba86e5b882e58d97e5b2b8e58cbafd260c046c6f676f06e59bbee78987fd170c89504e470d0a1a0a0000000d4948445200000050000000500803000000b9cf029f0000001974455874536f6674776172650041646f626520496d616765526561647971c9653c0000038869545874584d4c3a636f6d2e61646f62652e786d7000000000003c3f787061636b657420626567696e3d22efbbbf222069643d2257354d304d7043656869487a7265537a4e54637a6b633964223f3e203c783a786d706d65746120786d6c6e733a783d2261646f62653a6e733a6d6574612f2220783a786d70746b3d2241646f626520584d5020436f726520352e362d633133382037392e3135393832342c20323031362f30392f31342d30313a30393a30312020202020202020223e203c7264663a52444620786d6c6e733a7264663d22687474703a2f2f7777772e77332e6f72672f313939392f30322f32322d7264662d73796e7461782d6e7323223e203c7264663a4465736372697074696f6e207264663a61626f75743d222220786d6c6e733a786d704d4d3d22687474703a2f2f6e732e61646f62652e636f6d2f7861702f312e302f6d6d2f2220786d6c6e733a73745265663d22687474703a2f2f6e732e61646f62652e636f6d2f7861702f312e302f73547970652f5265736f75726365526566232220786d6c6e733a786d703d22687474703a2f2f6e732e61646f62652e636f6d2f7861702f312e302f2220786d704d4d3a4f726967696e616c446f63756d656e7449443d22786d702e6469643a63366435353139652d333762642d343630662d613136662d6263623131316565396535652220786d704d4d3a446f63756d656e7449443d22786d702e6469643a42333641414136314544434131314536394142353936384532413336433538422220786d704d4d3a496e7374616e636549443d22786d702e6969643a42333641414136304544434131314536394142353936384532413336433538422220786d703a43726561746f72546f6f6c3d2241646f62652050686f746f73686f7020434320323031352e3520284d6163696e746f736829223e203c786d704d4d3a4465726976656446726f6d2073745265663a696e7374616e636549443d22786d702e6969643a31663063653734362d373938392d616634662d396362342d393233623361313333346635222073745265663a646f63756d656e7449443d2261646f62653a646f6369643a70686f746f73686f703a36363933666334302d656463372d313165362d626534372d613738373163636365383764222f3e203c2f7264663a4465736372697074696f6e3e203c2f7264663a5244463e203c2f783a786d706d6574613e203c3f787061636b657420656e643d2272223f3ebee777fb00000180504c5445f75d4ff97c4bfa854af9794bfca546f7614ef8797cfcad6efee3d9fda946feeeeefcbca9f65150f54552f44152f54d51f43d53f65a4ffef2ecf54951f8796bfeebe3f43a53fca253fdcbbbfa9587fdd6c8f8827dfff4edfcab4ffdd9d6f76862f86a4df65450fb9848fbac99fdad45f98a88f66259f9897bfb9a47fa8e49f8764cf87a56fb9049f65c5afb9b51fcb499fcc2adf9804afa9352f8704cf87456f54c5bfb9548f86d4df5435cfa8b49fcb282f8744cf86f4df7684dfb9348f8724cfa8c49fc9e47fca346fb9248fc9c47fca047f7644ef6535afa8b54fcab83f7664ef98454f33254f76b57fb976afdcaacfdd6bcf33653f65964f43d5dfef0edfee6e1f9886bfa834afdb14efba18bf76b58fef1e5f33454fba584f97b5cfa9b74fdcba3feeeeafa884af9949cf76672f98574f9784cf76f57f76758fa8d74f87061fef0ebfee5cffa9059fa8949fef1edf6574ff9824af7674efb9b47f33753fca74ff65d53fba890f5485bfcc2bef97f4bf98f92f8754ffef0eefeefeefef2edae422d56000006994944415478daacd9f95f53391000f007ae50db0a54a88502dd96ca2550caa51cbaae2887a2dc15590456141094431716656dfbaf3b33495e32e92badbb3bbff7fb4932c964f2eabc36a3f575ab8c7388c8790422154989184c0d521ccd52cc89e899eba118c6d87fb9e5dc31e206c62f1893939353538f1f3f7efa575757575bdbbd7bbf3d79d2dbddddfdfbd8d8f14e6565e5dae781cbcb8a8a8abdbdbdbb13138f86861edcbf1f8f3ffcf27cda79adb93b051e826de801d8db2bbd1df206d0bb766def2e80ca7bf865faa50992774380a5bd4bd77b84de7df49e1be00d36e1293561e54990bc4aeded698f266c8ed07b01b937b6632e207a77d9029aa097e731e1e2de43f4ae7f50a05ec07f9f10f014682fa087d77d6542c484af6bd033215d5e0959b31232c43cc7044b25e4b8544234e8e13d2d9a9081a20901cfe900b08c052c2f21e009909f10af1d3d567a470b2fa4c1ab1332564642000c21582c216d3f9d100334bcf3c58d4fd5e4a516c2e18db07764c29958e0959510f04e05689698c59696968d088e6fa185475ec70945f6dbb02831aee7827a01a736f0b7e3b880e1a2e0898c7c6ccbf2006cb512f2097f5b8d09f19518200c311b351302de691f80bc4657c310ffbc87315edacb66d7cd053c3d4d00689598a791f188dc31d50b6ea417d23a02e94020d098412f1bbb6e4e3841a07542ba0a4fc8da67d8d103468979001b663846e221f31458aae67beee8750277b5076050806c47a7aa23d68e9eef5ff4853732d1c0fc3573473711d8692c6022284056622829a6b719d529f125f7f40991a0a33d0d1a2586b64dc4f58e1659826fc50e9417d7a05ac0603038e3b44ef205a43d32ae6afe7cc6dad1f9b7ebaac41098eb645e6d1f82acc4b82024e4783e5cb80357d76549403007a09b1004679c73abc408504cf8c827bd68e0e2a2bff1add8cf1f0f448969428f40b580b5b504f29a2f41f48e1bc9bb159d17356b2bf0910e886f9f4a8c04b52741abe60b9012b22dc6d70ffb4feee8ed0cce3a9ba492d0849e005dcf05f58e5620ec68ac64f9967ebda387860edee211ceec634968ca09d0f408e4274e8058f38ff238c0283f21fdb4579a9ec309166073482684bc7a00ad9a2f41d8d1e334e16d5ef387a9267c9bd6a04e08780046ac4b53803b708417d0f3d997661a411f964005ea09d74b905dc2043ec3921045306d7731e27c7c00b05d80c6024a909718094289f99497296697f0ae2a5a4e93020daf7ec4895897b000b164f924c82ecd7883041d8746e86f36bd9b085a6da502d73e0bd0ee6208cc1d4249c011fa0974c777f32682bc8b9120146905b22e26ee82a176f4fccd3a21e021682c2096180942cd17a0ddc534504938848ae082b505a059f30508355f81bc8bc129e714e827d0f46a469c94d5150910bb1801da5d4c039d60004fdbb30432cf00558d1620de7112b4da4a01fe0a07aeddef82ae4720bf34e9527f86771c8149b98071d5c534e40a41e949d0ba3469849b0668b5951284132cc02a36c09aaf08b2b6926ae0269618044f9213565be98e5083864720bf84a9c46c5608f0249fb4db4a35c284007355cc93a0d997d31db28925c187d53969f7e5124c24dc114a8fc43a00ad3e3f2f4028093ebc4092fae52aba2202fd0006258827580db00e41ebe52a402c3102b4fb7c09c2817341c32390bf5c2508274e81accf3f6da092c040e9d52138eaa4ac3e5f8058627cab08c6adbefc904e3080b512c409d7a801de1e7506ad879204e1c405f0c67cc51f4aa1509f0f9458d0008d092bd07c7809104b564fe36af8225ed0e757c5fcb1c31928091ad41e82565bf9518074e286ed8797eca34509fc87f6e17be611c81f4a74e0a213451e4a461753fb8d46b86c2ca000ad976b1ac1d5f4ab9e9e61fa5ab4bfbfff07c4078c8e8e8ebe8e3e8ae5e5247931ed217806a0f5729db7de0d227232fc76bc9327440e9040ebe5dae87a27055e01181ba961de12803b569fdf43fbaf3c2ff39e7b67672bcea0fd72fd3e172d7b7cef5942ce0458f8f4ff7e11cd96b180b1772335d6009796569c59cf6f315b07189d079dbb9d9dbbbbcdbbcd1855cd55462cf31d4d0354a0f7a7842fee8efe3bc4db54798578786f007417f0aa4f096e9fcf2f4d5962b447e0951fc73c4e08aff9dc43b0f4b798c209d77b4c98bc17000e14fd5ae9edb101f2057cf3428025beed145f40db13e065c96f3145bd9a020fc0b981ff94903aee11f8bf2464497808965ec0721322c1e25f2b7f36211a2c95904479095160390909164bc86dee01c87674fcaa1d5d2421c6026238b35becff0b889710e246c24b8962a66f8662646684e22bc628c5cae88a19a33f0418008e8f0f813207cbb40000000049454e44ae4260822b0a637265646974436f64650ce4bfa1e794a8e4bba3e7a0811239313530303130384d41355542333248334e1a0570686f6e6506e794b5e8af9d0c3032332d383633333130363927077765627369746506e5ae98e7bd911768747470733a2f2f7777772e696e636861696e2e6f7267fd1d0108646573637269707406e68f8fe8bfb0fd0a01e9878de5ba86e58db0e993bee7a791e68a80e69c89e99990e585ace58fb8e698afe4b880e5aeb6e4bba5e58cbae59d97e993bee68a80e69cafe9a9b1e58aa8e79a84e5889be696b0e59e8be4bc81e4b89aefbc8ce585b6e4b8bbe5afbce79a84e58cbae59d97e993bee7a4bee58cbae9a1b9e79bae496e636861696e2de58db0e993bee698afe4b880e4b8aae4bba5e998b2e4bcaae4b8bae59fbae7a180e4b89ae58aa1e79a84e585ace5bc80e5b9b3e58fb0efbc8ce4b8bae7a4bee4bc9ae59084e4bc81e4b89ae38081e69cbae69e84e38081e889bae69cafe5aeb6e7ad89e68f90e4be9be59381e7898ce38081e79fa5e8af86e4baa7e69d83e4bf9de68aa4e69c8de58aa1e380820221038556d02e429bdf8df33cae6424f0ce001d3437aa275ec08a3d7ea3b23c201e2e2103200192d31cc1993c0e1945a53fe5ebf904cd0484e0654a7400dec3054c99926b012102a4cdde3805b8903b9c447d3eb6479507cbcbc1bd8b829b46e57a2803e0e43c7a82c220d936ad91a50e918ebb8376c7335fb7d16255333ea859d64d7d4d1f309052c8f8c314716b68dd463d01263a7ff4a7c52eae528d71439688473045022100b744d933d97fe1ce596c331328e9560aad83faa4a94285d02c5fa82e121d9b5e02200ead8812f8b9c64fd0393a40e2445a78828af0c8a90d5a8de403a47dbe936b06ac0b01000000895263175d010000b326aeb9c6710864441b7c6a282ce924b4c317498e168bb4963f0523b9ee1c734d3c14297658193001fd080d2b046e616d6506e5908de7a7b01ee9878de5ba86e58db0e993bee7a791e68a80e69c89e99990e585ace58fb822076164647265737306e59cb0e59d8012e9878de5ba86e5b882e58d97e5b2b8e58cbafd260c046c6f676f06e59bbee78987fd170c89504e470d0a1a0a0000000d4948445200000050000000500803000000b9cf029f0000001974455874536f6674776172650041646f626520496d616765526561647971c9653c0000038869545874584d4c3a636f6d2e61646f62652e786d7000000000003c3f787061636b657420626567696e3d22efbbbf222069643d2257354d304d7043656869487a7265537a4e54637a6b633964223f3e203c783a786d706d65746120786d6c6e733a783d2261646f62653a6e733a6d6574612f2220783a786d70746b3d2241646f626520584d5020436f726520352e362d633133382037392e3135393832342c20323031362f30392f31342d30313a30393a30312020202020202020223e203c7264663a52444620786d6c6e733a7264663d22687474703a2f2f7777772e77332e6f72672f313939392f30322f32322d7264662d73796e7461782d6e7323223e203c7264663a4465736372697074696f6e207264663a61626f75743d222220786d6c6e733a786d704d4d3d22687474703a2f2f6e732e61646f62652e636f6d2f7861702f312e302f6d6d2f2220786d6c6e733a73745265663d22687474703a2f2f6e732e61646f62652e636f6d2f7861702f312e302f73547970652f5265736f75726365526566232220786d6c6e733a786d703d22687474703a2f2f6e732e61646f62652e636f6d2f7861702f312e302f2220786d704d4d3a4f726967696e616c446f63756d656e7449443d22786d702e6469643a63366435353139652d333762642d343630662d613136662d6263623131316565396535652220786d704d4d3a446f63756d656e7449443d22786d702e6469643a42333641414136314544434131314536394142353936384532413336433538422220786d704d4d3a496e7374616e636549443d22786d702e6969643a42333641414136304544434131314536394142353936384532413336433538422220786d703a43726561746f72546f6f6c3d2241646f62652050686f746f73686f7020434320323031352e3520284d6163696e746f736829223e203c786d704d4d3a4465726976656446726f6d2073745265663a696e7374616e636549443d22786d702e6969643a31663063653734362d373938392d616634662d396362342d393233623361313333346635222073745265663a646f63756d656e7449443d2261646f62653a646f6369643a70686f746f73686f703a36363933666334302d656463372d313165362d626534372d613738373163636365383764222f3e203c2f7264663a4465736372697074696f6e3e203c2f7264663a5244463e203c2f783a786d706d6574613e203c3f787061636b657420656e643d2272223f3ebee777fb00000180504c5445f75d4ff97c4bfa854af9794bfca546f7614ef8797cfcad6efee3d9fda946feeeeefcbca9f65150f54552f44152f54d51f43d53f65a4ffef2ecf54951f8796bfeebe3f43a53fca253fdcbbbfa9587fdd6c8f8827dfff4edfcab4ffdd9d6f76862f86a4df65450fb9848fbac99fdad45f98a88f66259f9897bfb9a47fa8e49f8764cf87a56fb9049f65c5afb9b51fcb499fcc2adf9804afa9352f8704cf87456f54c5bfb9548f86d4df5435cfa8b49fcb282f8744cf86f4df7684dfb9348f8724cfa8c49fc9e47fca346fb9248fc9c47fca047f7644ef6535afa8b54fcab83f7664ef98454f33254f76b57fb976afdcaacfdd6bcf33653f65964f43d5dfef0edfee6e1f9886bfa834afdb14efba18bf76b58fef1e5f33454fba584f97b5cfa9b74fdcba3feeeeafa884af9949cf76672f98574f9784cf76f57f76758fa8d74f87061fef0ebfee5cffa9059fa8949fef1edf6574ff9824af7674efb9b47f33753fca74ff65d53fba890f5485bfcc2bef97f4bf98f92f8754ffef0eefeefeefef2edae422d56000006994944415478daacd9f95f53391000f007ae50db0a54a88502dd96ca2550caa51cbaae2887a2dc15590456141094431716656dfbaf3b33495e32e92badbb3bbff7fb4932c964f2eabc36a3f575ab8c7388c8790422154989184c0d521ccd52cc89e899eba118c6d87fb9e5dc31e206c62f1893939353538f1f3f7efa575757575bdbbd7bbf3d79d2dbddddfdfbd8d8f14e6565e5dae781cbcb8a8a8abdbdbdbb13138f86861edcbf1f8f3ffcf27cda79adb93b051e826de801d8db2bbd1df206d0bb766def2e80ca7bf865faa50992774380a5bd4bd77b84de7df49e1be00d36e1293561e54990bc4aeded698f266c8ed07b01b937b6632e207a77d9029aa097e731e1e2de43f4ae7f50a05ec07f9f10f014682fa087d77d6542c484af6bd033215d5e0959b31232c43cc7044b25e4b8544234e8e13d2d9a9081a20901cfe900b08c052c2f21e009909f10af1d3d567a470b2fa4c1ab1332564642000c21582c216d3f9d100334bcf3c58d4fd5e4a516c2e18db07764c29958e0959510f04e05689698c59696968d088e6fa185475ec70945f6dbb02831aee7827a01a736f0b7e3b880e1a2e0898c7c6ccbf2006cb512f2097f5b8d09f19518200c311b351302de691f80bc4657c310ffbc87315edacb66d7cd053c3d4d00689598a791f188dc31d50b6ea417d23a02e94020d098412f1bbb6e4e3841a07542ba0a4fc8da67d8d103468979001b663846e221f31458aae67beee8750277b5076050806c47a7aa23d68e9eef5ff4853732d1c0fc3573473711d8692c6022284056622829a6b719d529f125f7f40991a0a33d0d1a2586b64dc4f58e1659826fc50e9417d7a05ac0603038e3b44ef205a43d32ae6afe7cc6dad1f9b7ebaac41098eb645e6d1f82acc4b82024e4783e5cb80357d76549403007a09b1004679c73abc408504cf8c827bd68e0e2a2bff1add8cf1f0f448969428f40b580b5b504f29a2f41f48e1bc9bb159d17356b2bf0910e886f9f4a8c04b52741abe60b9012b22dc6d70ffb4feee8ed0cce3a9ba492d0849e005dcf05f58e5620ec68ac64f9967ebda387860edee211ceec634968ca09d0f408e4274e8058f38ff238c0283f21fdb4579a9ec309166073482684bc7a00ad9a2f41d8d1e334e16d5ef387a9267c9bd6a04e08780046ac4b53803b708417d0f3d997661a411f964005ea09d74b905dc2043ec3921045306d7731e27c7c00b05d80c6024a909718094289f99497296697f0ae2a5a4e93020daf7ec4895897b000b164f924c82ecd7883041d8746e86f36bd9b085a6da502d73e0bd0ee6208cc1d4249c011fa0974c777f32682bc8b9120146905b22e26ee82a176f4fccd3a21e021682c2096180942cd17a0ddc534504938848ae082b505a059f30508355f81bc8bc129e714e827d0f46a469c94d5150910bb1801da5d4c039d60004fdbb30432cf00558d1620de7112b4da4a01fe0a07aeddef82ae4720bf34e9527f86771c8149b98071d5c534e40a41e949d0ba3469849b0668b5951284132cc02a36c09aaf08b2b6926ae0269618044f9213565be98e5083864720bf84a9c46c5608f0249fb4db4a35c284007355cc93a0d997d31db28925c187d53969f7e5124c24dc114a8fc43a00ad3e3f2f4028093ebc4092fae52aba2202fd0006258827580db00e41ebe52a402c3102b4fb7c09c2817341c32390bf5c2508274e81accf3f6da092c040e9d52138eaa4ac3e5f8058627cab08c6adbefc904e3080b512c409d7a801de1e7506ad879204e1c405f0c67cc51f4aa1509f0f9458d0008d092bd07c7809104b564fe36af8225ed0e757c5fcb1c31928091ad41e82565bf9518074e286ed8797eca34509fc87f6e17be611c81f4a74e0a213451e4a461753fb8d46b86c2ca000ad976b1ac1d5f4ab9e9e61fa5ab4bfbfff07c4078c8e8e8ebe8e3e8ae5e5247931ed217806a0f5729db7de0d227232fc76bc9327440e9040ebe5dae87a27055e01181ba961de12803b569fdf43fbaf3c2ff39e7b67672bcea0fd72fd3e172d7b7cef5942ce0458f8f4ff7e11cd96b180b1772335d6009796569c59cf6f315b07189d079dbb9d9dbbbbcdbbcd1855cd55462cf31d4d0354a0f7a7842fee8efe3bc4db54798578786f007417f0aa4f096e9fcf2f4d5962b447e0951fc73c4e08aff9dc43b0f4b798c209d77b4c98bc17000e14fd5ae9edb101f2057cf3428025beed145f40db13e065c96f3145bd9a020fc0b981ff94903aee11f8bf2464497808965ec0721322c1e25f2b7f36211a2c95904479095160390909164bc86dee01c87674fcaa1d5d2421c6026238b35becff0b889710e246c24b8962a66f8662646684e22bc628c5cae88a19a33f0418008e8f0f813207cbb40000000049454e44ae4260822b0a637265646974436f64650ce4bfa1e794a8e4bba3e7a0811239313530303130384d41355542333248334e1a0570686f6e6506e794b5e8af9d0c3032332d383633333130363927077765627369746506e5ae98e7bd911768747470733a2f2f7777772e696e636861696e2e6f72672008646573637269707406e68f8fe8bfb00fe8b4a6e688b7e7aea1e79086e591980221030b9ed4e617cde00ee7aa9ae76d81f9b5fa05d883b095927c7e06f743c7cfa5142103f489cd4acbbab11c3f504421456738cd0b8a57ca1ff19559dd330479b898e0c8012102aba9d34ea22fe374454cec1f893d52fd13f80e33e48542ec08bc277c3900ec4982c2207c96dc721df61d797328325873d14fe67aadb4feac07f33cd26b541aa5457c8ac3148e168bb4963f0523b9ee1c734d3c142976581930884730450221009d476a110c1ae779fc9d664fa7a0615ab0baa705b090d9946730205fe3c6ed1e02202ffda63ec1499a6f17b791d0748cffd3f27c26ec27f53678e64ac232482340ffac0b01000000dea567175d010000481e05c83604abf86cca029c4260674c45c85c58b326aeb9c6710864441b7c6a282ce924b4c3174901fd100d2b046e616d6506e5908de7a7b01ee9878de5ba86e58db0e993bee7a791e68a80e69c89e99990e585ace58fb822076164647265737306e59cb0e59d8012e9878de5ba86e5b882e58d97e5b2b8e58cbafd260c046c6f676f06e59bbee78987fd170c89504e470d0a1a0a0000000d4948445200000050000000500803000000b9cf029f0000001974455874536f6674776172650041646f626520496d616765526561647971c9653c0000038869545874584d4c3a636f6d2e61646f62652e786d7000000000003c3f787061636b657420626567696e3d22efbbbf222069643d2257354d304d7043656869487a7265537a4e54637a6b633964223f3e203c783a786d706d65746120786d6c6e733a783d2261646f62653a6e733a6d6574612f2220783a786d70746b3d2241646f626520584d5020436f726520352e362d633133382037392e3135393832342c20323031362f30392f31342d30313a30393a30312020202020202020223e203c7264663a52444620786d6c6e733a7264663d22687474703a2f2f7777772e77332e6f72672f313939392f30322f32322d7264662d73796e7461782d6e7323223e203c7264663a4465736372697074696f6e207264663a61626f75743d222220786d6c6e733a786d704d4d3d22687474703a2f2f6e732e61646f62652e636f6d2f7861702f312e302f6d6d2f2220786d6c6e733a73745265663d22687474703a2f2f6e732e61646f62652e636f6d2f7861702f312e302f73547970652f5265736f75726365526566232220786d6c6e733a786d703d22687474703a2f2f6e732e61646f62652e636f6d2f7861702f312e302f2220786d704d4d3a4f726967696e616c446f63756d656e7449443d22786d702e6469643a63366435353139652d333762642d343630662d613136662d6263623131316565396535652220786d704d4d3a446f63756d656e7449443d22786d702e6469643a42333641414136314544434131314536394142353936384532413336433538422220786d704d4d3a496e7374616e636549443d22786d702e6969643a42333641414136304544434131314536394142353936384532413336433538422220786d703a43726561746f72546f6f6c3d2241646f62652050686f746f73686f7020434320323031352e3520284d6163696e746f736829223e203c786d704d4d3a4465726976656446726f6d2073745265663a696e7374616e636549443d22786d702e6969643a31663063653734362d373938392d616634662d396362342d393233623361313333346635222073745265663a646f63756d656e7449443d2261646f62653a646f6369643a70686f746f73686f703a36363933666334302d656463372d313165362d626534372d613738373163636365383764222f3e203c2f7264663a4465736372697074696f6e3e203c2f7264663a5244463e203c2f783a786d706d6574613e203c3f787061636b657420656e643d2272223f3ebee777fb00000180504c5445f75d4ff97c4bfa854af9794bfca546f7614ef8797cfcad6efee3d9fda946feeeeefcbca9f65150f54552f44152f54d51f43d53f65a4ffef2ecf54951f8796bfeebe3f43a53fca253fdcbbbfa9587fdd6c8f8827dfff4edfcab4ffdd9d6f76862f86a4df65450fb9848fbac99fdad45f98a88f66259f9897bfb9a47fa8e49f8764cf87a56fb9049f65c5afb9b51fcb499fcc2adf9804afa9352f8704cf87456f54c5bfb9548f86d4df5435cfa8b49fcb282f8744cf86f4df7684dfb9348f8724cfa8c49fc9e47fca346fb9248fc9c47fca047f7644ef6535afa8b54fcab83f7664ef98454f33254f76b57fb976afdcaacfdd6bcf33653f65964f43d5dfef0edfee6e1f9886bfa834afdb14efba18bf76b58fef1e5f33454fba584f97b5cfa9b74fdcba3feeeeafa884af9949cf76672f98574f9784cf76f57f76758fa8d74f87061fef0ebfee5cffa9059fa8949fef1edf6574ff9824af7674efb9b47f33753fca74ff65d53fba890f5485bfcc2bef97f4bf98f92f8754ffef0eefeefeefef2edae422d56000006994944415478daacd9f95f53391000f007ae50db0a54a88502dd96ca2550caa51cbaae2887a2dc15590456141094431716656dfbaf3b33495e32e92badbb3bbff7fb4932c964f2eabc36a3f575ab8c7388c8790422154989184c0d521ccd52cc89e899eba118c6d87fb9e5dc31e206c62f1893939353538f1f3f7efa575757575bdbbd7bbf3d79d2dbddddfdfbd8d8f14e6565e5dae781cbcb8a8a8abdbdbdbb13138f86861edcbf1f8f3ffcf27cda79adb93b051e826de801d8db2bbd1df206d0bb766def2e80ca7bf865faa50992774380a5bd4bd77b84de7df49e1be00d36e1293561e54990bc4aeded698f266c8ed07b01b937b6632e207a77d9029aa097e731e1e2de43f4ae7f50a05ec07f9f10f014682fa087d77d6542c484af6bd033215d5e0959b31232c43cc7044b25e4b8544234e8e13d2d9a9081a20901cfe900b08c052c2f21e009909f10af1d3d567a470b2fa4c1ab1332564642000c21582c216d3f9d100334bcf3c58d4fd5e4a516c2e18db07764c29958e0959510f04e05689698c59696968d088e6fa185475ec70945f6dbb02831aee7827a01a736f0b7e3b880e1a2e0898c7c6ccbf2006cb512f2097f5b8d09f19518200c311b351302de691f80bc4657c310ffbc87315edacb66d7cd053c3d4d00689598a791f188dc31d50b6ea417d23a02e94020d098412f1bbb6e4e3841a07542ba0a4fc8da67d8d103468979001b663846e221f31458aae67beee8750277b5076050806c47a7aa23d68e9eef5ff4853732d1c0fc3573473711d8692c6022284056622829a6b719d529f125f7f40991a0a33d0d1a2586b64dc4f58e1659826fc50e9417d7a05ac0603038e3b44ef205a43d32ae6afe7cc6dad1f9b7ebaac41098eb645e6d1f82acc4b82024e4783e5cb80357d76549403007a09b1004679c73abc408504cf8c827bd68e0e2a2bff1add8cf1f0f448969428f40b580b5b504f29a2f41f48e1bc9bb159d17356b2bf0910e886f9f4a8c04b52741abe60b9012b22dc6d70ffb4feee8ed0cce3a9ba492d0849e005dcf05f58e5620ec68ac64f9967ebda387860edee211ceec634968ca09d0f408e4274e8058f38ff238c0283f21fdb4579a9ec309166073482684bc7a00ad9a2f41d8d1e334e16d5ef387a9267c9bd6a04e08780046ac4b53803b708417d0f3d997661a411f964005ea09d74b905dc2043ec3921045306d7731e27c7c00b05d80c6024a909718094289f99497296697f0ae2a5a4e93020daf7ec4895897b000b164f924c82ecd7883041d8746e86f36bd9b085a6da502d73e0bd0ee6208cc1d4249c011fa0974c777f32682bc8b9120146905b22e26ee82a176f4fccd3a21e021682c2096180942cd17a0ddc534504938848ae082b505a059f30508355f81bc8bc129e714e827d0f46a469c94d5150910bb1801da5d4c039d60004fdbb30432cf00558d1620de7112b4da4a01fe0a07aeddef82ae4720bf34e9527f86771c8149b98071d5c534e40a41e949d0ba3469849b0668b5951284132cc02a36c09aaf08b2b6926ae0269618044f9213565be98e5083864720bf84a9c46c5608f0249fb4db4a35c284007355cc93a0d997d31db28925c187d53969f7e5124c24dc114a8fc43a00ad3e3f2f4028093ebc4092fae52aba2202fd0006258827580db00e41ebe52a402c3102b4fb7c09c2817341c32390bf5c2508274e81accf3f6da092c040e9d52138eaa4ac3e5f8058627cab08c6adbefc904e3080b512c409d7a801de1e7506ad879204e1c405f0c67cc51f4aa1509f0f9458d0008d092bd07c7809104b564fe36af8225ed0e757c5fcb1c31928091ad41e82565bf9518074e286ed8797eca34509fc87f6e17be611c81f4a74e0a213451e4a461753fb8d46b86c2ca000ad976b1ac1d5f4ab9e9e61fa5ab4bfbfff07c4078c8e8e8ebe8e3e8ae5e5247931ed217806a0f5729db7de0d227232fc76bc9327440e9040ebe5dae87a27055e01181ba961de12803b569fdf43fbaf3c2ff39e7b67672bcea0fd72fd3e172d7b7cef5942ce0458f8f4ff7e11cd96b180b1772335d6009796569c59cf6f315b07189d079dbb9d9dbbbbcdbbcd1855cd55462cf31d4d0354a0f7a7842fee8efe3bc4db54798578786f007417f0aa4f096e9fcf2f4d5962b447e0951fc73c4e08aff9dc43b0f4b798c209d77b4c98bc17000e14fd5ae9edb101f2057cf3428025beed145f40db13e065c96f3145bd9a020fc0b981ff94903aee11f8bf2464497808965ec0721322c1e25f2b7f36211a2c95904479095160390909164bc86dee01c87674fcaa1d5d2421c6026238b35becff0b889710e246c24b8962a66f8662646684e22bc628c5cae88a19a33f0418008e8f0f813207cbb40000000049454e44ae4260822b0a637265646974436f64650ce4bfa1e794a8e4bba3e7a0811239313530303130384d41355542333248334e1a0570686f6e6506e794b5e8af9d0c3032332d383633333130363927077765627369746506e5ae98e7bd911768747470733a2f2f7777772e696e636861696e2e6f72672808646573637269707406e68f8fe8bfb017e8aea4e8af81e8b4a6e688b7e7aea1e79086e591985f3102210270e28d48a47214c3e6a2218dca5739b84707050b877a7c09b14c4f91a95aa6132102f673cbe24bae7f76dd16f8b9c6cac50d3254c83babb273bae9f1356dce7ce8d70121029f9fd5aa79e4d11e8cb939eef347cc91701326548b94956d00396ec69823026381c220cd302b848c606d981ec5979bef9b8232cc009d7b6d928ccb716d0f755033b327c314b326aeb9c6710864441b7c6a282ce924b4c31749884630440220239ff5502358876835388523cc4baae20424b037dfe79d5beeb22faa2188ea1e02200d5b4fe5af151d3e89d1504fbf25f2b3439742348d35d7424a24d79d0b986413ac"));

		Sha256Hash merkleHash = gengsisBlock.getBlock().buildMerkleHash();

		if(log.isDebugEnabled()) {
			log.debug("the gengsis block merkle hash is : {}", merkleHash);
		}
		Utils.checkState("7f623f71d05834105ef7f56034a320c5d3b04ded8b78e28cbe49907452ab3b58".equals(Hex.encode(merkleHash.getBytes())), "the gengsis block merkle hash is error");

		if(log.isDebugEnabled()) {
			log.debug("the gengsis block hash key is : {}", gengsisBlock.getBlock().getHash());
		}
		Utils.checkState("597f0456ebd21c0818ccf88f70b276c9526f876c4789a39fb885490638e002cf".equals(Hex.encode(gengsisBlock.getBlock().getHash().getBytes())), "the gengsis block hash is error");

		return gengsisBlock;
	}
	
	@Override
	public int getProtocolVersionNum(ProtocolVersion version) {
		return version.getVersion();
	}

	@Override
	public MessageSerializer getSerializer(boolean parseRetain) {
		return new DefaultMessageSerializer(this);
	}

	/**
	 * 获取该网络的认证管理账号的hash160
	 * @return byte[]
	 */
	@Override
	public byte[] getCertAccountManagerHash160() {


		//return Hex.decode("8e168bb4963f0523b9ee1c734d3c142976581930");//root
		//return Hex.decode("b326aeb9c6710864441b7c6a282ce924b4c31749");//manager
		return Hex.decode("481e05c83604abf86cca029c4260674c45c85c58");//cer_manager_1
	}

	@Override
	public byte[] getCommunityManagerHash160() {
		return Hex.decode("481e05c83604abf86cca029c4260674c45c85c58");//cer_manager_1
	}

	/**
	 * 测试网络，普通地址以t开头
	 */
	@Override
	public int getSystemAccountVersion() {
		return 128;
	}

	/**
	 * 测试网络，认证地址以c开头
	 */
	@Override
	public int getCertAccountVersion() {
		return 88;
	}
}

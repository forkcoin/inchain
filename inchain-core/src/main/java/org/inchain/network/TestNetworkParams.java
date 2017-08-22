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

//    	seedManager.add(new Seed(new InetSocketAddress("47.93.16.125", Configure.DEFAULT_PORT)));
//    	seedManager.add(new Seed(new InetSocketAddress("119.23.249.26", Configure.DEFAULT_PORT)));
//   	seedManager.add(new Seed(new InetSocketAddress("119.23.253.3", Configure.DEFAULT_PORT)));
//    	seedManager.add(new Seed(new InetSocketAddress("119.23.254.99", Configure.DEFAULT_PORT)));
		seedManager.add(new Seed(new InetSocketAddress("47.92.26.16", Configure.DEFAULT_PORT)));
		seedManager.add(new Seed(new InetSocketAddress("47.92.29.121", Configure.DEFAULT_PORT)));
		seedManager.add(new Seed(new InetSocketAddress("47.92.4.19", Configure.DEFAULT_PORT)));
		seedManager.add(new Seed(new InetSocketAddress("47.93.16.125", Configure.DEFAULT_PORT)));
//		seedManager.add(new Seed(new InetSocketAddress("192.168.1.2", Configure.DEFAULT_PORT)));
//		seedManager.add(new Seed(new InetSocketAddress("192.168.1.151", Configure.DEFAULT_PORT)));
//		seedManager.add(new Seed(new InetSocketAddress("192.168.1.152", Configure.DEFAULT_PORT)));
//		seedManager.add(new Seed(new InetSocketAddress("192.168.1.153", Configure.DEFAULT_PORT)));
//		seedManager.add(new Seed(new InetSocketAddress("192.168.1.156", Configure.DEFAULT_PORT)));
//		seedManager.add(new Seed(new InetSocketAddress("192.168.1.157", Configure.DEFAULT_PORT)));
//		seedManager.add(new Seed(new InetSocketAddress("192.168.1.158", Configure.DEFAULT_PORT)));
//		seedManager.add(new Seed(new InetSocketAddress("192.168.1.159", Configure.DEFAULT_PORT)));
     	init();
	}


	public TestNetworkParams(SeedManager seedManager) {
		this.seedManager = seedManager;
		init();
	}

	private void init() {

		id = ID_TESTNET;

		packetMagic = 6294836898L;

		this.acceptableAddressCodes = new int[] {getSystemAccountVersion(), getCertAccountVersion()};
	}

	/**
	 * 测试网络的创世块
	 */
	@Override
	public BlockStore getGengsisBlock() {
		BlockStore gengsisBlock = new BlockStore(this, Hex.decode("00000000000000000000000000000000000000000000000000000000000000000000000000cc3019924136d3f7ccdd2bc73066941f916c2ea728bf91a4b781c6ab8677e6fdda7e59000000000000fdda7e59832102883a9625a871e79c070e316edafc97eac2f6c97b218d0e55726f25be2a963e9276a9144237cccf6ff9a7674a8fc47c60278fdd23e9f30988473045022100822be165776411571bee4f885a2785dacef21506408788024490b8d63883b14202207c2071d5cbaa367a7c7e22160c540347b8aa51dee1b4c42c3670b9a49f3d3566ac140101000000010012117468697320612067656e6773697320747800000000010080faca73f91f00000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688acfdda7e59000000000002010000000101c58e0dfe559f48f3eae222e0d679dd648e70e7c0f4af06bcd5c2b510fcb7e837000000006a473044022055c76d8395f95118958e71ad2a10db0bf62bdc54dd129686cd334fb2a84dc2390220787796e6a843140091ce6aa807118f2ec5727cb468d20c2aea65738684be9a4501210276c52ff14acd4c4d3e08f9596e0127a15e98207b3d0024426364825cd724c86dffffffff020080c6a47e8d03000078c2481976a9144237cccf6ff9a7674a8fc47c60278fdd23e9f30988ac00003426f56b1c00000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688acfeda7e5900000000000601000000feda7e59822102883a9625a871e79c070e316edafc97eac2f6c97b218d0e55726f25be2a963e9276a9144237cccf6ff9a7674a8fc47c60278fdd23e9f30988463044022100c8276028ab51982a34fa3d3aa5b5749669ae44448fd2bbf1c2e98bee64e96353021f459cd25897462a186ecea74984b29d5167be43954d9e23185f81d5b2931e24ac4237cccf6ff9a7674a8fc47c60278fdd23e9f30901000000000000000000000000000000000000000000000000000000000000000000000000000000000002010000000101d071ee50c095aa0c51c0b4d1eae4783fd60c17eeeaf055ed35d15697f5a8aa1a010000006a473044022074cf760a00d5bc6fb01baa24a94fa2b7cea3ee770138dc4fe9bd167ea8b7224c02202c3a421fa6c7b0e1df152d31ffd3406bd8ba2c2b26f4ad04234db6d587afdcbb01210276c52ff14acd4c4d3e08f9596e0127a15e98207b3d0024426364825cd724c86dffffffff020010a5d4e8000000000000001976a9144237cccf6ff9a7674a8fc47c60278fdd23e9f30988ac00c0b91502111c00000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688acfeda7e59000000000003010000000000feda7e590000000000822102883a9625a871e79c070e316edafc97eac2f6c97b218d0e55726f25be2a963e9276a9144237cccf6ff9a7674a8fc47c60278fdd23e9f3098846304402204b2eb744c120e5484a8c8f78bc56242a4dd29501a47776a6600d9d5a36a05d7f02205c4816cf6230ba3c9d6f77d517242256ba33dfa85ab7d74dc9ede6d8339823f7ac82db86974237cccf6ff9a7674a8fc47c60278fdd23e9f3090601000000feda7e59832103a7db4a854e3f2ae3a30aa759bfd39045f6a80c967b3fd81036acebc54b557ece76a9142c1179b1e05fb8652644f6c61a033d28431009128847304502210091bc31854e35679cf0d590de1744dd1d58414ea8c602baa6c002c6d16270a76c02204a208ca7f5e4b07e7c525ff7f13885ff9e64598321b6c826c0d89f2f11b74ec7ac2c1179b1e05fb8652644f6c61a033d2843100912010000000000000000000000000000000000000000000000000000000000000000000000000000000000020100000001016f18243ef25c20e27b444018c6d3973afe5dc5e17a76900a35602934abfcbc6d010000006a473044022047e4be626483eb49874d84cace06f6270e7069ef03b17607e6c154d3314792a802201761c8d752fb4f3ced897e8681b5348dbb6620b5e87f4b3044726279215c870f01210276c52ff14acd4c4d3e08f9596e0127a15e98207b3d0024426364825cd724c86dffffffff020010a5d4e8000000000000001976a9142c1179b1e05fb8652644f6c61a033d284310091288ac00803f050fb61b00000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688acfeda7e59000000000003010000000000feda7e590000000000822103a7db4a854e3f2ae3a30aa759bfd39045f6a80c967b3fd81036acebc54b557ece76a9142c1179b1e05fb8652644f6c61a033d284310091288463044022063ed166fb3e3302156799053c1965be1a4b14c4be4388495803285fb336c4a5f02207995aaae813270e78a4e81538404ee806d9e479b2449d4200fe46d3991bcb563ac95db86972c1179b1e05fb8652644f6c61a033d28431009120601000000feda7e598321033e371b2f3d42dd525833bcce12cb0d404fb73898bdea3e6794bd8ec552c9ba9c76a914b3fcd687a5c2b2617de0d504cfa7d12db93bb00c88473045022100a7037bbf30c8a7b1d5d4889611b6a7847e1890a183772144fe0d7b31cc8239de02203dbcc972e939993be5a630c762aa7e71aa13e8c32db89694789df883e8b5bdf6acb3fcd687a5c2b2617de0d504cfa7d12db93bb00c01000000000000000000000000000000000000000000000000000000000000000000000000000000000002010000000101fc68d536143f463dc9faf5f7fd91c164a7452430190428909231bc5b35dc4f49010000006a473044022022e49a752f7b0cc62eaafd5e674c05fc1f8912b3f4ab06f6f08a620e0ab99d02022026f5d1ca0afc368a0fcae5ba9d3d5e4e302d44f45511bcef3549243b2d8d6d4701210276c52ff14acd4c4d3e08f9596e0127a15e98207b3d0024426364825cd724c86dffffffff020010a5d4e8000000000000001976a914b3fcd687a5c2b2617de0d504cfa7d12db93bb00c88ac0040c5f41b5b1b00000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688acfeda7e59000000000003010000000000feda7e5900000000008321033e371b2f3d42dd525833bcce12cb0d404fb73898bdea3e6794bd8ec552c9ba9c76a914b3fcd687a5c2b2617de0d504cfa7d12db93bb00c88473045022100a1582b1152f841141f58e7039dafda5188ebd86337e79f382e87c1d3c485b7f002203fdd9d53d015fd700c3177f16dffbbcff928a439fdd03eb50aae3617ff4c520aac9adb8697b3fcd687a5c2b2617de0d504cfa7d12db93bb00c0601000000feda7e59832103bf7759e9b81f8ff1b99732b3ee36aea0abff68c818b8839c318ad350e9642cb076a914c3bfdb8a67f35b6e4ea1ee3ae7b91eff58ec81a8884730450221008ed069cd3d6a80b581988134f5064a0da1318f4c76d69bb7499a4d2000a1561c02204cd2c2662e9b8c0ec042d5a815ec7be626c6c5cf9be9ce6885e0e373d23f32a2acc3bfdb8a67f35b6e4ea1ee3ae7b91eff58ec81a8010000000000000000000000000000000000000000000000000000000000000000000000000000000000020100000001017bf6dec121b65c8c8ce4f9d22fbf644733fea228e351180585033bde0e1b85a2010000006a473044022028dc85f0e5c6c2a868825943c175013abe82f1085a03ad90f8e9857992f440ed0220744b338f005d43731e717f31a873cfec5803ef42ccc1ff4087b01aef5e8fd31401210276c52ff14acd4c4d3e08f9596e0127a15e98207b3d0024426364825cd724c86dffffffff020010a5d4e8000000000000001976a914c3bfdb8a67f35b6e4ea1ee3ae7b91eff58ec81a888ac00004be428001b00000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688acfeda7e5900000000000601000000feda7e5983210200d482122f8537ad2fa1af1914e088d6b308824a8ef4dc8b68fa0e0a88c484e376a9145f1a078b610d92a3110b2c1a7f880b0d2442e53088473045022100c36001db4676050eef55bc0f9100c761e3c72517defc1fa3b43e15736f5283eb0220494f9b47180e83ea508046ac51789b451b4475688b12773539bc8bdb891f4615ac5f1a078b610d92a3110b2c1a7f880b0d2442e53001000000000000000000000000000000000000000000000000000000000000000000000000000000000002010000000101f7e2e4ba55fab9e14f17e80cb3dc40e26b1efb3689ed1d2fd1de6fb96b2e7412010000006a47304402200dba9df5c1445d73af50a0f6f13469f6e4c50abeb1958073b3b0aa5fdca1b2410220472c198c3fc288f651a0f552932f51f3989ed8b457e76e138b1527e5be0d008101210276c52ff14acd4c4d3e08f9596e0127a15e98207b3d0024426364825cd724c86dffffffff020010a5d4e8000000000000001976a9145f1a078b610d92a3110b2c1a7f880b0d2442e53088ac00c0d0d335a51a00000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688acfeda7e5900000000000601000000feda7e59832103e8769d1901a4ef006054405c16716d6648fffe628385db5586c7fa18c3df5da876a914df639c6066a817a6be28b532839f8e1e85594cd488473045022100ac7e5e7b619007a14c997edb67ea8027c53aee3803bc11f855aeb7b709abb6d002206c8970a35f68620130f80b3350a2a929e1258e8169eeb128141770411d2259bbacdf639c6066a817a6be28b532839f8e1e85594cd401000000000000000000000000000000000000000000000000000000000000000000000000000000000002010000000101d952e5a18d84d31851f2945406586d909323709c054d6c2a4f6993b1cc37207e010000006a473044022076f0a9cdd46046a3fdf018a21e8d1be98e46510b6c8dfff26206836b34d1c641022067ff8112c3f430dfab5e15eb9288f29786a8f7781520e3d387373150453d66cc01210276c52ff14acd4c4d3e08f9596e0127a15e98207b3d0024426364825cd724c86dffffffff020010a5d4e8000000000000001976a914df639c6066a817a6be28b532839f8e1e85594cd488ac008056c3424a1a00000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688acfeda7e5900000000000601000000feda7e59832103368f8061e02694e37da199c07c3e2f2506cdd748efee493f0d1c52ae7494428f76a914e3453a80144f6ac24baf01f20455c6167b985485884730450221009a406555174e5ace2a970281cd9ee5480ff3a380f5e83a3640f65bf1b6ecb815022003f3691301ff45fe4cf91a013bb9dd0c4450f5bae9912cc9ec4868a88ec6d96bace3453a80144f6ac24baf01f20455c6167b9854850100000000000000000000000000000000000000000000000000000000000000000000000000000000000201000000010137ad0d22028c39abc39d21066ee7ae9d7b495ad048a17f9b4a14a48af998e68d010000006a47304402206b8d399e52b28bb5cfa5153f4c8909fb2549b9b8097864e47e29a387d84a0f71022079535b406d28416a3b9268be689113a0f100c46bbcb74d7fdaac6f3302a34db301210276c52ff14acd4c4d3e08f9596e0127a15e98207b3d0024426364825cd724c86dffffffff020010a5d4e8000000000000001976a914e3453a80144f6ac24baf01f20455c6167b98548588ac0040dcb24fef1900000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688acfeda7e5900000000000b0100000043da7e5982c220256303b7fa1e89761bf37c1a8415524dbcb9ec1b4033ce71d4224699e8459235c314dd1c14ee4f4642eb9c3e14cc97a3c3d3629708ea88473045022100c50a56f6bb25ea2ade3b83def48d7b55401916f711a634a8b2163b555343cef502203cda9a0c6735c72cf4599def1eaec90f32206e69ded301be46168aa2ad0286aaacdd1c14ee4f4642eb9c3e14cc97a3c3d3629708eadd1c14ee4f4642eb9c3e14cc97a3c3d3629708ea01fd23022b046e616d6506e5908de7a7b01ee9878de5ba86e58db0e993bee7a791e68a80e69c89e99990e585ace58fb822076164647265737306e59cb0e59d8012e9878de5ba86e5b882e58d97e5b2b8e58cba44046c6f676f06e59bbee7898737687474703a2f2f66696c652e696e636861696e2e6f72672f696d616765732f696e636861696e5f6c6f676f5f313030783130302e706e672b0a637265646974436f64650ce4bfa1e794a8e4bba3e7a0811239313530303130384d41355542333248334e1a0570686f6e6506e794b5e8af9d0c3032332d383633333130363927077765627369746506e5ae98e7bd911768747470733a2f2f7777772e696e636861696e2e6f7267fd1d0108646573637269707406e68f8fe8bfb0fd0a01e9878de5ba86e58db0e993bee7a791e68a80e69c89e99990e585ace58fb8e698afe4b880e5aeb6e4bba5e58cbae59d97e993bee68a80e69cafe9a9b1e58aa8e79a84e5889be696b0e59e8be4bc81e4b89aefbc8ce585b6e4b8bbe5afbce79a84e58cbae59d97e993bee7a4bee58cbae9a1b9e79bae496e636861696e2de58db0e993bee698afe4b880e4b8aae4bba5e998b2e4bcaae4b8bae59fbae7a180e4b89ae58aa1e79a84e585ace5bc80e5b9b3e58fb0efbc8ce4b8bae7a4bee4bc9ae59084e4bc81e4b89ae38081e69cbae69e84e38081e889bae69cafe5aeb6e7ad89e68f90e4be9be59381e7898ce38081e79fa5e8af86e4baa7e69d83e4bf9de68aa4e69c8de58aa1e380820221023cbfda1ae93a41187634206177a0482ee2c890540bd907a7f6fbdde9e5a31c3b2103489e3933f41327c2463b664776a4355860cf5b093c106d21f0253f83dda76465012103df243c24dfe4ea420c776e8d46fbc2a86c6e439648119f64b583a38a0c7d84fd00"));

		Sha256Hash merkleHash = gengsisBlock.getBlock().buildMerkleHash();

		if(log.isDebugEnabled()) {
			log.debug("the gengsis block merkle hash is : {}", merkleHash);
		}
		Utils.checkState("00cc3019924136d3f7ccdd2bc73066941f916c2ea728bf91a4b781c6ab8677e6".equals(Hex.encode(merkleHash.getBytes())), "the gengsis block merkle hash is error");

		if(log.isDebugEnabled()) {
			log.debug("the gengsis block hash key is : {}", gengsisBlock.getBlock().getHash());
		}
		Utils.checkState("e4a5a20311b59e5edada67cb1edcd71e3e2f7dd74139ea9d05e21cf5c9a10212".equals(Hex.encode(gengsisBlock.getBlock().getHash().getBytes())), "the gengsis block hash is error");

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

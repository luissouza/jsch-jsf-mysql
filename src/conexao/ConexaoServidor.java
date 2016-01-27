package conexao;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class ConexaoServidor {

	private String sFtpHost = "1.1.1.72";
	private int sFtpPort = 22;
	private String sFtpUser = "oracle";
	private String sFtpPass = "amazonas@123";
	private Session session = null;
	private Channel channel = null;
	private ChannelSftp channelSftp = null;

	public void iniciarConexao() {
		try {
			JSch jsch = new JSch();

			session = jsch.getSession(sFtpUser, sFtpHost, sFtpPort);
			session.setPassword(sFtpPass);
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
			channel = session.openChannel("sftp");
			channel.connect();
			channelSftp = (ChannelSftp) channel;

		} catch (JSchException e) {
			e.printStackTrace();

		}

	}

	public ChannelSftp getChannelSftp() {
		return channelSftp;
	}

	public void setChannelSftp(ChannelSftp channelSftp) {
		this.channelSftp = channelSftp;
	}
}

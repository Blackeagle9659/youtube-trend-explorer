package data.model;

public class VideoData {
	private String textVideo;
	private String date;
	private String view;
	private String like;
	private String labelElement;

	public VideoData(String textVideo, String date, String view, String like, String labelElement) {

		this.textVideo = textVideo;
		this.date = date;
		this.view = view;
		this.like = like;
		this.labelElement = labelElement;
	}

	public String getTextVideo() {
		return textVideo;
	}

	public String getDate() {
		return date;
	}

	public String getView() {
		return view;
	}

	public String getLike() {
		return like;
	}

	public String getLabelElement() {
		return labelElement;
	}

	@Override
	public String toString() {
		return "📦 [VIDEO PACKAGE]\n" + "  -> Text: " + textVideo + "\n" + "  -> Date: " + date + "\n" + "  -> Views: "
				+ view + "\n" + "  -> Likes: " + like + "\n" + "  -> Secret Label: " + labelElement + "\n"
				+ "-------------------------------------------------";
	}
}
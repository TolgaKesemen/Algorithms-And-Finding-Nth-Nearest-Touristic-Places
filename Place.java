package FindingNearestNPlaces;

public class Place implements Comparable<Place>{
		private int x;
		private int y;
		private int fee;
		private int distance;
		private int index;
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public int getFee() {
			return fee;
		}
		public void setFee(int fee) {
			this.fee = fee;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public int getDistance() {
			return distance;
		}
		public void setDistance(int distance) {
			this.distance = distance;
		}
		@Override
		public int compareTo(Place o) {
			return new Integer(this.fee).compareTo(o.fee);
		}
}

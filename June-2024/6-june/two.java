class TimeMap{
	private Map<String, List<Pair<Integer, String>>> map;

	public TimeMap(){
		this.map = new HashMap<>();
	}

	public void set(String key, String value, int timestamp){
		List<Pair<Integer, String>> list = this.map.get(key);
		if (list == null){
			list = new ArrayList<>();
			this.map.put(key, list);
		}
		list.add(new Pair<>(timestamp, value));
	}

	public String get(String key, int timestamp){
		List<Pair<Integer, String>> list = this.map.get(key);
		if (list == null){
			return "";
		}

		int first = 0, nextOfLast = list.size();
		while (first < nextOfLast){
			final int mid = first + (nextOfLast - first) / 2;

			if (list.get(mid).getKey() <= timestamp){
				first = mid + 1;
			}else {
				nextOfLast = mid;
			}
		}

		return (nextOfLast - 1 >= 0)? list.get(nextOfLast - 1).getValue() : "";
	}
}

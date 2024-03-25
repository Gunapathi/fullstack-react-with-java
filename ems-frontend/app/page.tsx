import Image from "next/image";
import React from "react";

async function getData() {
	const res = await fetch("http://localhost:3434/ems/invoice/fetch");
	// The return value is *not* serialized
	// You can return Date, Map, Set, etc.

	if (!res.ok) {
		// This will activate the closest `error.js` Error Boundary
		throw new Error("Failed to fetch data");
	}

	return res.json();
}

export default async function Home() {
	const data = await getData();

	// LOG
	console.log(data);

	return (
		<main className="flex min-h-screen flex-col items-center justify-between p-24">
			<div className="z-10 max-w-5xl w-full items-center justify-between font-mono text-sm lg:flex">
				<p className="fixed left-0 top-0 flex w-full justify-center border-b border-gray-300 bg-gradient-to-b from-zinc-200 pb-6 pt-8 backdrop-blur-2xl dark:border-neutral-800 dark:bg-zinc-800/30 dark:from-inherit lg:static lg:w-auto  lg:rounded-xl lg:border lg:bg-gray-200 lg:p-4 lg:dark:bg-zinc-800/30">
					{data?.response.map((item: any, index: number) => (
						<React.Fragment key={index}>
							<div>
								<p>{item.userName}</p>
								<p>{item.invoiceId}</p>
							</div>
						</React.Fragment>
					))}
				</p>
			</div>
		</main>
	);
}
